package ast.expression;

import ast.AbstractASTNode;
import ast.type.Type;
import examples.ast.ASTNode;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    private boolean lValue;
    private Type type;
    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean getLvalue() {
        return this.lValue;
    }

    @Override
    public void setLvalue(boolean lvalue) {
        this.lValue = lvalue;
    }

    @Override
    public Type getType() {
        return type;
    }
    @Override
    public void setType(Type type) {
        this.type = type;
    }
}
