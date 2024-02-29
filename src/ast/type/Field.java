package ast.type;

import ast.AbstractASTNode;

public class Field extends AbstractASTNode {

    private Type type;
    private String name;

    public Field(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return type.toString() + name;
    }
}
