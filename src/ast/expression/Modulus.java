package ast.expression;

import ast.AbstractASTNode;
import visitor.Visitor;

public class Modulus extends AbstractExpression implements Expression{

    private Expression left;
    private Expression right;

    public Modulus(int line, int column, Expression left , Expression right) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return left + "%" + right;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
