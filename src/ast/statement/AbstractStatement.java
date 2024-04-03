package ast.statement;

import ast.AbstractASTNode;
import ast.type.Type;
import semantic.visitor.Visitor;

public abstract class AbstractStatement extends AbstractASTNode implements Statement{

    private Type returnType;

    public AbstractStatement(int line, int column) {
        super(line, column);
    }

    @Override
    public Type getReturnType() {
        return this.returnType;
    }

    @Override
    public void setReturnType(Type r) {
        this.returnType = r;
    }
}
