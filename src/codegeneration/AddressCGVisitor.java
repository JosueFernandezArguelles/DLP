package codegeneration;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;
import semantic.visitor.Visitor;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {
    /*
        address[[Variable: exp -> ID]] = if( exp.definition.scope == 0 ){
                                            <pusha> exp.definition.offset
                                         } else{
                                            <push bp>
                                            <pushi> exp.definition.offset
                                            <addi>
                                         }
    */

    private CodeGenerator cg;

    public AddressCGVisitor(CodeGenerator cg){
        this.cg = cg;
    }

    @Override
    public Void visit(Variable v, Void param) {
        cg.pushAddress( v );
        return null;
    }
}
