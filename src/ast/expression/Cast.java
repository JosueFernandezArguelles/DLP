package ast.expression;

import ast.AbstractASTNode;
import ast.type.Type;

public class Cast extends AbstractASTNode implements Expression{

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
        return "Cast{" + "(" + type + ")" + expression + '}';
    }
}
