package ast.type;

import ast.AbstractASTNode;
import semantic.visitor.Visitor;

public class VoidType extends AbstractType{
    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public int getNumberOfBytes() {
        return 0;
    }

}
