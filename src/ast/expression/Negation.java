package ast.expression;

import ast.AbstractASTNode;

public class Negation extends AbstractASTNode implements Expression{

    private Expression expression;

    public Negation(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return this.expression;
    }
}