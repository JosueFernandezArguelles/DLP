package ast.expression;

import semantic.visitor.Visitor;

public class UnaryMinus extends AbstractExpression{

    private Expression expression;
    public UnaryMinus(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression(){
        return this.expression;
    }

    @Override
    public String toString() {
        return "-" + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
