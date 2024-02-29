package ast.type;

import ast.AbstractASTNode;

public class ArrayType extends AbstractASTNode implements Type{

    private Type type;
    private int size;
    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.size = size;
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return type.toString() + "[" + size + "]";
    }
}
