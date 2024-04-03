package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.visitor.Visitor;

public class Write extends AbstractStatement {

    private Expression expression;
    public Write(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpressions(){
        return this.expression;
    }

    @Override
    public String toString() {
        return "write" + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
