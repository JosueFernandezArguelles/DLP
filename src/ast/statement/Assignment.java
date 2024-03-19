package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.visitor.Visitor;

public class Assignment extends AbstractASTNode implements Statement {

    private Expression target;
    private Expression value;
    public Assignment(int line, int column, Expression target, Expression value) {
        super(line, column);
        this.target = target;
        this.value = value;
    }

    public Expression getTarget() {
        return this.target;
    }

    public Expression getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return target + "=" + value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
