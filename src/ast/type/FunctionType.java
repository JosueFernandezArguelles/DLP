package ast.type;

import ast.AbstractASTNode;
import ast.program.VariableDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractASTNode implements Type {

    private Type returnType;
    private List<VariableDefinition> parameters;
    public FunctionType(int line, int column, Type returnType, List<VariableDefinition> parameters) {
        super(line, column);
        this.returnType = returnType;
        this.parameters = new ArrayList<>(parameters);
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public List<VariableDefinition> getParameters() {
        return this.parameters;
    }

    @Override
    public String toString() {
        return  returnType.toString() + parameters.toString();
    }
}
