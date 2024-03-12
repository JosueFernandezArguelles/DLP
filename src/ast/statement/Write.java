package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

import java.util.List;

public class Write extends AbstractASTNode implements Statement {

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
