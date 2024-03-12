package ast.program;

import ast.AbstractASTNode;
import ast.type.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition  {

    private String name;
    private Type type;

    public AbstractDefinition(String name, Type type, int line, int column){
        super( line, column );
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return type.toString() + " " + name;
    }
}
