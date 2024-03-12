package ast.type;

import ast.AbstractASTNode;
import visitor.Visitor;

public class IntegerType extends AbstractASTNode implements Type{
    public IntegerType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "int ";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
