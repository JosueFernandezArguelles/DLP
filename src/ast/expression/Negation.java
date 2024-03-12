package ast.expression;

import ast.AbstractASTNode;

public class Negation extends AbstractExpression implements Expression{

    private Expression expression;

    public Negation(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return this.expression;
    }

    @Override
    public String toString() {
        return "!" + expression.toString();
    }
}
