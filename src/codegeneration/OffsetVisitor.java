package codegeneration;

import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.type.FunctionType;
import ast.type.Type;
import semantic.visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    /*
        (P) -> (1) FunctionDefinition: functionDefinition -> type ID variableDefinition* statement*
               (2) FunctionType: type1 -> type2 variableDefinition*
               (3) VarDefinition: variableDefinition -> type ID
               (4) RecordType: type -> field*

        (R) -> Local Variables (1) int localByteSum = 0;
                                   for( VarDefinition vd : variableDefinition* ){
                                        localByteSum += vd.type.numberOfBytes
                                        vd.offset = -localByteSum;
                                   }
               Parameters (2) int paramByteSum = 0;
                                   for( int i = variableDefinition*.size()-1; i >= 0; i-- ){
                                        VarDefinition vd = variableDefinition*.get(i);
                                        vd.offset = 4 + paramByteSum;
                                        paramByteSum += vd.type.numberOfBytes();
                                   }
               Globals (3) if( scope == 0 ){
                               int globalByteSum = 0;
                               variableDefinition.offset = globalByteSum;
                               globalByteSum += type.numberOfBytes();
                            }
                Field (4) int fieldByteSum = 0;
                          for(Field f : field*){
                              f.offset = fieldByteSum;
                              fieldByteSum += f.type.numberOfBytes()
                          }
    */


    private int globalByteSum = 0;

    @Override
    public Void visit(FunctionDefinition f, Void param){
        super.visit(f, param);
        int localByteSum = 0;
        for(VariableDefinition vd : f.getVariables()){
            localByteSum += vd.getType().getNumberOfBytes();
            vd.setOffset(localByteSum);
        }
        return null;
    }

    @Override
    public Void visit(FunctionType f, Void param){
        super.visit(f, param);
        int paramByteSum = 0;
        for(int i = f.getParameters().size() - 1; i >= 0; i--){
            VariableDefinition vd = f.getParameters().get(i);
            vd.setOffset(4 + paramByteSum);
            paramByteSum += vd.getType().getNumberOfBytes();
        }
        return null;
    }

    @Override
    public Void visit(VariableDefinition v, Void param){
        super.visit(v, param);
        if(v.getScope() == 0){
            v.setOffset(globalByteSum);
            globalByteSum += v.getType().getNumberOfBytes();
        }
        return null;
    }
}
