package ast.program;

import ast.type.Type;

public class VariableDefinition extends AbstractDefinition implements Definition {

    private int offset;

    public VariableDefinition(int line, int column, Type type, String name, int offset) {
        super(name, type, line, column);
        this.offset = offset;
    }

    public int getOffset(){
        return this.offset;
    }
}
