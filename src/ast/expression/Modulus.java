package ast.expression;

import ast.AbstractASTNode;

public class Modulus extends AbstractASTNode implements Expression{

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
}
