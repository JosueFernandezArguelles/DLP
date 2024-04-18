package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.Assignment;
import ast.statement.Read;
import ast.statement.Write;
import ast.type.FunctionType;
import ast.type.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<FunctionDefinition, Void>{

    /*
        execute[[Read: statement -> expression]]= value[[expression]]
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
    */

    @Override
    public Void visit(Read r, FunctionDefinition fd){
        r.getExpression().accept(new ValueCGVisitor(), null);
        r.addCode("in " + r.getExpression().getType().suffix() + " \n");
        r.addCode("store " + r.getExpression().getType().suffix() + " \n");
        return null;
    }

    @Override
    public Void visit(Write w, FunctionDefinition fd){
        w.getExpressions().accept(new ValueCGVisitor(), null);
        w.addCode("out " + w.getExpressions().getType().suffix() + " \n");
        return null;
    }

    @Override
    public Void visit(Assignment a, FunctionDefinition fd){
        a.getTarget().accept(new AddressCGVisitor(), null);
        a.getValue().accept(new ValueCGVisitor(), null);
        a.addCode("store " + a.getTarget().getType().suffix() + " \n");
        return null;
    }

    @Override
    public Void visit(VariableDefinition vd, FunctionDefinition fd){
        vd.addCode( String.format( "'*%s %s (offset %s)",  vd.getType().toString(), vd.getName(), vd.getOffset()));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition fd, FunctionDefinition param){
        fd.addCode(fd.getName() + ": \n");
        fd.getType().accept(this, param);
        fd.addCode("'*Local Variables: \n");
        fd.getVariables().forEach(v -> v.accept(this, param));
        int bytesLocals = fd.getVariables().isEmpty() ? 0 : -fd.getVariables().get(fd.getVariables().size()-1).getOffset();
        fd.addCode("enter " + bytesLocals + " \n");
        int bytesParameters = ((FunctionType)fd.getType()).getParameters().stream().mapToInt(p -> p.getType().getNumberOfBytes()).sum();
        int bytesReturn = ((FunctionType) fd.getType()).getReturnType().getNumberOfBytes();
        fd.getStatements().forEach(s -> s.accept(this, param));
        if(((FunctionType) fd.getType()).getReturnType() instanceof VoidType){
            fd.addCode("ret " + bytesReturn + "," + bytesLocals + "," + bytesParameters + " \n");
        }
        return null;
    }

    @Override
    public Void visit(Program p, FunctionDefinition param){
        p.addCode("call main \n");
        p.addCode("halt \n");
        p.addCode("'* Global Variables: \n");
        p.getDefinitions().forEach( d -> d.accept(this, param) );
        return null;
    }
}