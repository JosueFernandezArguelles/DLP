package ast.type;

import ast.AbstractASTNode;
import semantic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType{

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


    @Override
    public Type dot(String s){
        for( Field f : fields ){
            if( f.getName().equals(s) ){
                return f.getType();
            }
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "No %s field", s));
    }

    @Override
    public int getNumberOfBytes() {
        return this.fields.stream().mapToInt( rf -> rf.getType().getNumberOfBytes() ).sum();
    }
}
