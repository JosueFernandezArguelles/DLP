package ast.program;

import ast.type.Type;

public class VariableDefinition extends AbstractDefinition implements Definition {

    private int offset;

    public VariableDefinition(String name, Type type, int line, int column, int offset) {
        super(name, type, line, column);
        this.offset = offset;
    }

    public int getOffset(){
        return this.offset;
    }
}
