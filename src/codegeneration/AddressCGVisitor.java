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

         //Lab 12
         address[[Indexing: exp1 -> exp2 exp3]] = address[[exp2]]
                                                  value[[exp3]]
                                                  <pushi> exp1.type.getNumberOfBytes()
                                                  <muli>
                                                  <addi>

          address[[FieldAccess: exp1 -> exp2 ID]] = address[[exp2]]
                                                    <pushi> exp2.type.getField(ID).offset
                                                    <addi>
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

    @Override
    public Void visit(Indexing i, Void param) {
        i.getVariable().accept(this, param);
        i.getIndex().accept(new ValueCGVisitor(cg), null);
        cg.push(((ArrayType)i.getType()).getType().getNumberOfBytes());
        cg.muli();
        cg.addi();
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void param) {
        f.getExpression().accept(this, param);
        cg.push(((RecordType)f.getExpression().getType()).getField(f.getFieldName()).getOffset());
        cg.addi();
        return null;
    }
}
