package ast.type;

import ast.AbstractASTNode;
import ast.program.VariableDefinition;
import semantic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Type> t){
        if( t.size() != parameters.size()  ){
            return new ErrorType(this.getLine(), this.getColumn(), "Wrong number of parameters");
        }

        int count = 0;

        for( Type type : t ){
            Type parameterType = parameters.get(count++).getType();
            if( type.getClass() != parameterType.getClass() ){
                return new ErrorType(type.getLine(), type.getColumn(),
                        String.format( "Parameter number %s must be %s", count, parameterType));
            }
        }
        return this.returnType;
    }
}
