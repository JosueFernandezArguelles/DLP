package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

public class ReturnStatement extends AbstractASTNode implements Statement {

    private Expression expression;
    public ReturnStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }
}
