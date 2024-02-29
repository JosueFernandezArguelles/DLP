package ast.expression;

import ast.AbstractASTNode;

public class Arithmetic extends AbstractASTNode implements Expression{

    private String operator;
    private Expression left;
    private Expression right;

    public Arithmetic(int line, int column, Expression left , String operator,  Expression right) {
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
}
