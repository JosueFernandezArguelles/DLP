package ast.type;

import ast.AbstractASTNode;
import visitor.Visitor;

public class DoubleType extends AbstractASTNode implements Type{
    public DoubleType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "double ";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
