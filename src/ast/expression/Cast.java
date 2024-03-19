package ast.expression;

import ast.type.Type;
import semantic.visitor.Visitor;

public class Cast extends AbstractExpression{

    private Expression expression;
    private Type type;
    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.type = type;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "(" + type.toString() + ")" + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
