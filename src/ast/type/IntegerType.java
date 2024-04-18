package ast.type;

import ast.AbstractASTNode;
import semantic.visitor.Visitor;

public class IntegerType extends AbstractType{
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

    @Override
    public Type arithmetic(Type t) {

        if( t instanceof ErrorType ){
            return t;
        }

        return t instanceof IntegerType ? this :
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

        return t instanceof IntegerType ? this :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s can not be compared to %s", t.toString(), this ));
    }

    @Override
    public Type logical(Type t) {

        if( t instanceof ErrorType ){
            return t;
        }

        return t instanceof IntegerType ? this :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s and %s can not be used for logical operations", t.toString(), this ));
    }

    @Override
    public Type modulus(Type t) {

        if( t instanceof ErrorType ){
            return t;
        }

        return t instanceof CharType || t instanceof IntegerType ? this :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s and %s can not be used for modulus operations", t.toString(), this ));
    }

    @Override
    public Type negation() {
        return this;
    }

    @Override
    public Type unaryMinus() {
        return this;
    }

    @Override
    public void assign(Type t){

        if( t instanceof ErrorType ) {
            return;
        }

        if( ! (t instanceof IntegerType)  ){
         new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s and %s can not be used for assignment operations", this, t));
        }
    }

    @Override
    public void mustBeReadable() {}
    @Override
    public void mustBeWritable() {}
    @Override
    public void mustBeBoolean() {}

    @Override
    public void returnAs(Type t){

        if( ! (t instanceof IntegerType)  ){
             new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "Return type must be %s ", t));
        }
    }

    @Override
    public int getNumberOfBytes() {
        return 2;
    }

    @Override
    public String suffix(){
        return "i";
    }

    @Override
    public String convertTo(Type t){
        if( t instanceof CharType ){
            return "i2b \n";
        } else if (t instanceof IntegerType) {
            return "";
        } else if (t instanceof DoubleType) {
            return "i2f \n";
        } else {
            throw new UnsupportedOperationException(String.format("Wrong conversion from %s to %s", this, t.toString()));
        }
    }

    @Override
    public Type superType(Type t){
        return t instanceof DoubleType ? t : this;
    }
}
