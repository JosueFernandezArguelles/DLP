package ast.expression;

import ast.AbstractASTNode;
import visitor.Visitor;

public class FieldAccess extends AbstractExpression{
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
        return  expression.toString() + "." + fieldName;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
