package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

public class Read extends AbstractASTNode implements Statement {

    private Expression expression;
    public Read(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }
}
