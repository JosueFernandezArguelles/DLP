package ast.type;

import ast.AbstractASTNode;
import semantic.visitor.Visitor;

public class DoubleType extends AbstractType{
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

    @Override
    public Type arithmetic(Type t) {
        return t instanceof DoubleType ? this :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s can not be used in an arithmetic operation with %s", t.toString(), this ));
    }

    @Override
    public Type castTo(Type t){
        return t instanceof CharType || t instanceof IntegerType || t instanceof DoubleType ? t :
                new ErrorType(this.getLine(), this.getColumn(), String.format( "%s can not be cast to %s", t.toString(), this ));
    }

    @Override
    public Type comparation(Type t) {
        return t instanceof DoubleType ? new IntegerType(this.getLine(), this.getColumn()) :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s can not be compared to %s", t.toString(), this ));
    }

    @Override
    public Type unaryMinus() {
        return this;
    }

    @Override
    public void assign(Type t){
        if( ! (t instanceof DoubleType)  ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "%s and %s can not be used for assignment operations", this, t));
        }
    }

    @Override
    public void mustBeReadable() {}
    @Override
    public void mustBeWritable() {}

    @Override
    public void returnAs(Type t){
        if( ! (t instanceof DoubleType)  ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "Return time must be %s ", this));
        }
    }
}
