package ast.type;

import ast.AbstractASTNode;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractASTNode implements Type{

    private List<Field> fields;
    public RecordType(int line, int column, List<Field> fields) {
        super(line, column);
        this.fields = new ArrayList<>(fields);
    }

    public List<Field> getFields() {
        return this.fields;
    }

    @Override
    public String toString() {
        return "RecordType{" +  fields.toString() + '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
