package ast.expression;

import ast.AbstractASTNode;

public class Variable extends AbstractExpression implements Expression{

    private String name;
    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
