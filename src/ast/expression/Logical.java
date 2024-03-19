package ast.expression;

import semantic.visitor.Visitor;

public class Logical extends AbstractExpression{

    private String operator;
    private Expression left;
    private Expression right;

    public Logical(int line, int column, Expression left, String operator, Expression right) {
        super(line, column);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return this.operator;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return left.toString() + operator + right.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
