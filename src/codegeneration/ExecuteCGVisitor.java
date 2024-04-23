package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.FunctionType;
import ast.type.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<FunctionDefinition, Void>{

    /*
        execute[[Read: statement -> expression]]= address[[expression]]
                                                  <in> expression.type.suffix()
                                                  <store> expression.type.suffix()

        execute[[Write: statement -> expression]]= value[[expression]]
                                                   <out> expression.type.suffix()

        execute[[Assignment: statement -> exp1 exp2]]= address[[exp1]]
                                                       value[[exp2]]
                                                       <store> exp1.type.suffix()

        execute[[VariableDefinition: varDefinition -> type ID]] = <'*> type.toString() ID <(offset> varDefinition.offset <)>

        execute[[FunctionDefinition: functionDefinition -> type ID variableDefinition* statement*]] =
                    ID <:>
                    execute[[type]]
                    <'* Local Variables:>
                    variableDefinition*.forEach(v -> execute[[v]])
                    int bytesLocals = variableDefinition*.isEmpty  ? 0 : - variableDefinition*.get(variableDefinition*.size()-1).offset
                    <enter> bytesLocals
                    int bytesParameters = type.parameters.stream().mapToInt( p -> type.noB()).sum();
                    int bytesReturn = type.returnType.noB()
                    statement*.forEach(s -> execute[[s]](bytesReturn, bytesLocals, bytesParameters))
                    if(type.returnType instanceof VoidType)
                        <ret> bytesReturn <,> bytesLocals <,> bytesParameters

        execute[[Program: program -> definition*]] = <call main>
                                                     <halt>
                                                     <'* Global Variables:>
                                                     definition*.forEach(d -> execute[[d]])

        //LAB 12

        execute[[While: stm1 -> exp stm2* ]] = String condLabel = cg.netLabel();
                                               String exitLabel = cg.netLabel();
                                               condLabel <:>
                                               value[[exp]]
                                               <jz> exitLabel
                                               stm2*.forEach( s -> execute[[s]] )
                                               <jmp> condLabel
                                               exitLabel<:>

        execute[[ConditionalStatement: stm1 -> exp stm2* stm3*]] = String elseLabel = cg.nextLabel();
                                                                   String exitLabel = cg.nextLabel();
                                                                   value[[exp]]
                                                                   <jz> elseLabel:
                                                                   stm2*.forEach( s -> execute[[s]] )
                                                                   <jmp> exitLabel
                                                                   elseLabel:
                                                                   stm3*.forEach( s -> execute[[s]] )
                                                                   exitLabel:
    */

    private CodeGenerator cg;

    public ExecuteCGVisitor(CodeGenerator cg){
        this.cg = cg;
    }

    @Override
    public Void visit(Read r, FunctionDefinition fd){
        r.getExpression().accept(new AddressCGVisitor(cg), null);
        cg.in( r.getExpression().getType() );
        cg.store( r.getExpression().getType() );
        return null;
    }

    @Override
    public Void visit(Write w, FunctionDefinition fd){
        cg.addComment("'* Write: Line " + w.getLine() );
        w.getExpressions().accept(new ValueCGVisitor(cg), null);
        cg.out(w.getExpressions().getType());
        return null;
    }

    @Override
    public Void visit(Assignment a, FunctionDefinition fd){
        a.getTarget().accept(new AddressCGVisitor(cg), null);
        a.getValue().accept(new ValueCGVisitor(cg), null);
        cg.store( a.getTarget().getType() );
        return null;
    }

    @Override
    public Void visit(VariableDefinition vd, FunctionDefinition fd){
        cg.addComment( String.format( "'*%s %s (offset %s)",  vd.getType().toString(), vd.getName(), vd.getOffset()) );
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fd, FunctionDefinition param){
        cg.tag(fd);
        //fd.getType().accept(this, param);
        fd.getVariables().forEach(v -> v.accept(this, param));
        int bytesLocals = fd.getVariables().isEmpty() ? 0 : -fd.getVariables().get(fd.getVariables().size()-1).getOffset();
        if( bytesLocals != 0 ){
            cg.addComment("'*Local Variables:");
            cg.enter(bytesLocals);
        }
        int bytesParameters = ((FunctionType)fd.getType()).getParameters().stream().mapToInt(p -> p.getType().getNumberOfBytes()).sum();
        int bytesReturn = fd.getType() instanceof VoidType ? 0 : ((FunctionType) fd.getType()).getReturnType().getNumberOfBytes();
        fd.getStatements().forEach(s -> s.accept(this, param));
        if(((FunctionType) fd.getType()).getReturnType() instanceof VoidType){
            cg.ret(bytesReturn, bytesLocals, bytesParameters);
        }
        return null;
    }

    @Override
    public Void visit(Program p, FunctionDefinition param){
        cg.mainFunction();
        p.getDefinitions().forEach( d -> d.accept(this, param) );
        return null;
    }

    @Override
    public Void visit(While w, FunctionDefinition param){
        String condLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();
        cg.addComment("'*While:");
        cg.addLabel(condLabel);
        w.getCondition().accept(new ValueCGVisitor(cg), null);
        cg.jumpZero(exitLabel);
        w.getBody().forEach( s -> s.accept(this, null) );
        cg.jump(condLabel);
        cg.addLabel(exitLabel);
        return null;
    }

    @Override
    public Void visit(ConditionalStatement c, FunctionDefinition param){
        String elseLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();
        c.getCondition().accept(new ValueCGVisitor(cg), null);
        cg.jumpZero(elseLabel);
        c.getIfStatements().forEach(s -> s.accept(this, null));
        cg.jump(exitLabel);
        cg.addLabel(elseLabel);
        c.getElseStatements().forEach( s -> s.accept(this, null));
        cg.addLabel(exitLabel);
        return null;
    }
}