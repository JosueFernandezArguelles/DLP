package ast.expression;

import ast.AbstractASTNode;
import examples.ast.ASTNode;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    private boolean lValue;
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
}
