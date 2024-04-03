package ast.expression;

import ast.type.Type;
import semantic.visitor.Visitor;

public class Cast extends AbstractExpression{

    private Expression expression;
    private Type castType;
    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.castType = type;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public Type getCastType() {
        return this.castType;
    }

    @Override
    public String toString() {
        return "(" + castType.toString() + ")" + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
