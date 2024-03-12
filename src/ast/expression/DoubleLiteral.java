package ast.expression;

import ast.AbstractASTNode;
import visitor.Visitor;

public class DoubleLiteral extends AbstractExpression{

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
