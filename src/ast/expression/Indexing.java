package ast.expression;

import ast.AbstractASTNode;

public class Indexing extends AbstractASTNode implements Expression{

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
}
