package codegeneration;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;
import semantic.visitor.Visitor;

public class AddressCGVisitor  {


    /*
        address[[Variable: exp -> ID]] = if( exp.definition.scope == 0 ){
                                            <pusha> exp.definition.offset
                                         } else{
                                            <push bp>
                                            <pushi> exp.definition.offset
                                            <addi>
                                         }
    */
}
