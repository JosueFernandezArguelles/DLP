package ast.program;

import ast.type.Type;
import semantic.visitor.Visitor;

public class VariableDefinition extends AbstractDefinition{

    private int offset;

    public VariableDefinition(int line, int column, Type type, String name, int offset) {
        super(name, type, line, column);
        this.offset = offset;
    }

    public VariableDefinition(int line, int column, String name, Type type) {
        super(name, type, line, column);
    }

    public int getOffset(){
        return this.offset;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

}
