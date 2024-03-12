package ast.expression;

import ast.AbstractASTNode;
import visitor.Visitor;

public class IntLiteral extends AbstractExpression implements Expression{

    private int value;
    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
