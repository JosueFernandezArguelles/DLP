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
        if( t instanceof ErrorType ){
            return t;
        }
        return t instanceof DoubleType ? this :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s can not be used in an arithmetic operation with %s", t.toString(), this ));
    }

    @Override
    public Type castTo(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return t instanceof CharType || t instanceof IntegerType || t instanceof DoubleType ? t :
                new ErrorType(this.getLine(), this.getColumn(), String.format( "%s can not be cast to %s", t.toString(), this ));
    }

    @Override
    public Type comparation(Type t) {
        if( t instanceof ErrorType ){
            return t;
        }
        return t instanceof DoubleType ? new BooleanType(t.getLine(), t.getColumn()) :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s can not be compared to %s", t.toString(), this ));
    }

    @Override
    public Type unaryMinus() {
        return this;
    }

    @Override
    public void assign(Type t){

        if( t instanceof ErrorType ){
            return;
        }

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
                    String.format( "Return type must be %s ", t));
        }
    }

    @Override
    public int getNumberOfBytes() {
        return 4;
    }

    @Override
    public String suffix(){
        return "f";
    }

    @Override
    public String convertTo(Type t){
        if( t instanceof CharType ){
            return "f2i \ni2b \n";
        } else if (t instanceof IntegerType) {
            return "f2i \n";
        } else if (t instanceof DoubleType) {
            return "";
        } else {
            throw new UnsupportedOperationException(String.format("Wrong conversion from %s to %s", this, t.toString()));
        }
    }

    @Override
    public Type superType(Type t){
        return this;
    }
}
