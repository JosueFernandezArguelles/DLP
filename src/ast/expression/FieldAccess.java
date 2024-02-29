package ast.expression;

import ast.AbstractASTNode;

public class FieldAccess extends AbstractASTNode implements Expression{
    private String fieldName;
    private Expression expression;
    public FieldAccess(int line, int column, Expression expression, String fieldName) {
        super(line, column);
        this.fieldName = fieldName;
        this.expression = expression;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Expression getExpression() {
        return this.expression;
    }

    @Override
    public String toString() {
        return "FieldAccess{" + expression + "." + fieldName + '}';
    }
}
