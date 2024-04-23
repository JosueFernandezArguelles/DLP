package codegeneration;

import ast.expression.FunctionInvocation;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.FunctionType;
import ast.type.Type;
import ast.type.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<BytesDTO, Void>{

    /*
        execute[[Read: statement -> expression]](int bytesLocal, int bytesParam, int bytesReturn)= address[[expression]]
                                                  <in> expression.type.suffix()
                                                  <store> expression.type.suffix()

        execute[[Write: statement -> expression]](int bytesLocal, int bytesParam, int bytesReturn)= value[[expression]]
                                                   <out> expression.type.suffix()

        execute[[Assignment: statement -> exp1 exp2]](int bytesLocal, int bytesParam, int bytesReturn)= address[[exp1]]
                                                       value[[exp2]]
                                                       <store> exp1.type.suffix()

        execute[[VariableDefinition: varDefinition -> type ID]](int bytesLocal, int bytesParam, int bytesReturn) = <'*> type.toString() ID <(offset> varDefinition.offset <)>

        execute[[FunctionDefinition: functionDefinition -> type ID variableDefinition* statement*]](int bytesLocal, int bytesParam, int bytesReturn) =
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

        execute[[Program: program -> definition*]](int bytesLocal, int bytesParam, int bytesReturn) = <call main>
                                                     <halt>
                                                     <'* Global Variables:>
                                                     definition*.forEach(d -> execute[[d]])

        //LAB 12

        execute[[While: stm1 -> exp stm2* ]](int bytesLocal, int bytesParam, int bytesReturn) =
                                               String condLabel = cg.netLabel();
                                               String exitLabel = cg.netLabel();
                                               condLabel <:>
                                               value[[exp]]
                                               <jz> exitLabel
                                               stm2*.forEach( s -> execute[[s]](bytesReturn, bytesLocals, bytesParameters) )
                                               <jmp> condLabel
                                               exitLabel<:>

        execute[[ConditionalStatement: stm1 -> exp stm2* stm3*]](int bytesLocal, int bytesParam, int bytesReturn) =
                                                                   String elseLabel = cg.nextLabel();
                                                                   String exitLabel = cg.nextLabel();
                                                                   value[[exp]]
                                                                   <jz> elseLabel:
                                                                   stm2*.forEach( s -> execute[[s]](bytesReturn, bytesLocals, bytesParameters) )
                                                                   <jmp> exitLabel
                                                                   elseLabel:
                                                                   stm3*.forEach( s -> execute[[s]](bytesReturn, bytesLocals, bytesParameters) )
                                                                   exitLabel:

        //Lab 13

        execute[[FunctionInvocation: stm -> exp1 exp2*]](int bytesLocal, int bytesParam, int bytesReturn) =
                                                              exp2*.forEach( e -> value[[e]] )
                                                              <call> exp1.name
                                                              Type t = ((FunctionType)exp1.definition.type).returnType
                                                              if( !(t instanceOf VoidType) ){
                                                                <pop> t.suffix()
                                                              }

        execute[[ReturnStatement: stm -> exp]](int bytesLocal, int bytesParam, int bytesReturn) =
                                                            value[[exp]]
                                                            <ret> bytesLocal, bytesParam, bytesReturn
    */

    private CodeGenerator cg;

    public ExecuteCGVisitor(CodeGenerator cg){
        this.cg = cg;
    }

    @Override
    public Void visit(Read r, BytesDTO fd){
        cg.addLine(r.getLine());
        cg.addComment("'* Read: ");
        r.getExpression().accept(new AddressCGVisitor(cg), null);
        cg.in( r.getExpression().getType() );
        cg.store( r.getExpression().getType() );
        return null;
    }

    @Override
    public Void visit(Write w, BytesDTO fd){
        cg.addLine(w.getLine());
        cg.addComment("'* Write: ");
        w.getExpressions().accept(new ValueCGVisitor(cg), null);
        cg.out(w.getExpressions().getType());
        return null;
    }

    @Override
    public Void visit(Assignment a, BytesDTO fd){
        cg.addLine(a.getLine());
        a.getTarget().accept(new AddressCGVisitor(cg), null);
        a.getValue().accept(new ValueCGVisitor(cg), null);
        cg.store( a.getTarget().getType() );
        return null;
    }

    @Override
    public Void visit(VariableDefinition vd, BytesDTO fd){
        cg.addComment( String.format( "'*%s %s (offset %s)",  vd.getType().toString(), vd.getName(), vd.getOffset()) );
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fd, BytesDTO param){
        cg.addLine(fd.getLine());
        cg.tag(fd);
        cg.addComment("'*Local Variables:");
        fd.getVariables().forEach(v -> v.accept(this, param));
        int bytesLocals = fd.getVariables().isEmpty() ? 0 : -fd.getVariables().get(fd.getVariables().size()-1).getOffset();
        if( bytesLocals != 0 ){
            cg.enter(bytesLocals);
        }
        int bytesParameters = ((FunctionType)fd.getType()).getParameters().stream().mapToInt(p -> p.getType().getNumberOfBytes()).sum();
        int bytesReturn = fd.getType() instanceof VoidType ? 0 : ((FunctionType) fd.getType()).getReturnType().getNumberOfBytes();
        BytesDTO dto = new BytesDTO(bytesLocals, bytesParameters, bytesReturn);
        fd.getStatements().forEach(s -> s.accept(this, dto));
        if(((FunctionType) fd.getType()).getReturnType() instanceof VoidType){
            cg.ret(bytesReturn, bytesLocals, bytesParameters);
        }
        return null;
    }

    @Override
    public Void visit(Program p, BytesDTO param){
        cg.addComment("'* Main Function:");
        cg.mainFunction();
        p.getDefinitions().forEach( d -> d.accept(this, param) );
        return null;
    }

    @Override
    public Void visit(While w, BytesDTO param){
        String condLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();
        cg.addLine(w.getLine());
        cg.addComment("'*While:");
        cg.addLabel(condLabel);
        w.getCondition().accept(new ValueCGVisitor(cg), null);
        cg.jumpZero(exitLabel);
        w.getBody().forEach( s -> s.accept(this, param) );
        cg.jump(condLabel);
        cg.addLabel(exitLabel);
        return null;
    }

    @Override
    public Void visit(ConditionalStatement c, BytesDTO param){
        String elseLabel = cg.nextLabel();
        String exitLabel = cg.nextLabel();
        cg.addLine(c.getLine());
        c.getCondition().accept(new ValueCGVisitor(cg), null);
        cg.jumpZero(elseLabel);
        c.getIfStatements().forEach(s -> s.accept(this, param));
        cg.jump(exitLabel);
        cg.addLabel(elseLabel);
        c.getElseStatements().forEach( s -> s.accept(this, param));
        cg.addLabel(exitLabel);
        return null;
    }

    @Override
    public Void visit(ReturnStatement r, BytesDTO param){
        cg.addLine(r.getLine());
        r.getExpression().accept(new ValueCGVisitor(cg), null);
        cg.ret(param.getReturnBytes(), param.getLocalBytes(), param.getParamBytes());
        return null;
    }

    @Override
    public Void visit(FunctionInvocation f, BytesDTO param){
        cg.addLine(f.getLine());
        f.getExpressionList().forEach(e -> e.accept(new ValueCGVisitor(cg), null));
        cg.call(f.getVariable().getName());
        Type t = ((FunctionType)f.getVariable().getDefinition().getType()).getReturnType();
        if(!(t instanceof VoidType)){
            cg.pop(t);
        }
        return null;
    }
}