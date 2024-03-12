package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

public class ReturnStatement extends AbstractASTNode implements Statement {

    private Expression expression;
    public ReturnStatement(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }

    @Override
    public String toString() {
        return "return" + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
