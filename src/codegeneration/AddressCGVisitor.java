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

    @Override
    public Void visit(Variable v, Void param) {
        VariableDefinition vd = (VariableDefinition) v.getDefinition();
        if(v.getDefinition().getScope() == 0){
            v.addCode("pusha " + vd.getOffset() + " \n" );
        } else {
            v.addCode("push bp \n" + "pushi" + vd.getOffset() + "\n" + "addi \n");
        }
        return null;
    }
}
