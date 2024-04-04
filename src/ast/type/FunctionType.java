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
    public Type parenthesis(Type[] t){
        if( t.length != parameters.size()  ){
            return new ErrorType(this.getLine(), this.getColumn(), "Wrong number of parameters");
        }

        for( int i = 0; i < parameters.size(); i++ ){
            Type type =  parameters.get(i).getType();
            if( type != t[i] ){
                return new ErrorType(type.getLine(), type.getColumn(),
                        String.format( "Parameter number %s must be %s", i, type));
            }
        }
        return this.returnType;
    }

    @Override
    public void returnAs(Type t){
        if( ! (t instanceof FunctionType)  ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "Return type must be %s ", this));
        }
    }
}
