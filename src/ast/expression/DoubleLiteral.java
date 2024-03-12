package ast.expression;

import ast.AbstractASTNode;

public class DoubleLiteral extends AbstractExpression implements Expression{

    private double value;
    public DoubleLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return "DoubleLiteral{" + value + '}';
    }
}
