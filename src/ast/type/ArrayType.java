package ast.type;

import ast.AbstractASTNode;
import semantic.visitor.Visitor;

public class ArrayType extends AbstractType{

    private Type type;
    private int size;
    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.size = size;
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return type.toString() + " [" + size + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type t){
        return t instanceof IntegerType ? this.type : new ErrorType(this.getLine(), this.getColumn(),
                String.format( "You can not be use %s inside [ ]", t));
    }

    @Override
    public void assign(Type t){
        if( ! (t instanceof ArrayType)  ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "%s and %s can not be used for assignment operations", this, t));
        }
    }

    @Override
    public void returnAs(Type t){
        if( ! (t instanceof ArrayType)  ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "Return time must be %s ", this));
        }
    }
}
