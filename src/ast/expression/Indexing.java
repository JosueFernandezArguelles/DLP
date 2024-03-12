package ast.expression;

import ast.AbstractASTNode;
import visitor.Visitor;

public class Indexing extends AbstractExpression implements Expression{

    private Expression variable;
    private Expression index;
    public Indexing(int line, int column, Expression variable, Expression index) {
        super(line, column);
        this.variable = variable;
        this.index = index;
    }

    @Override
    public String toString() {
        return variable.toString() + "[" + index.toString() + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
