package ast.type;

import ast.AbstractASTNode;
import semantic.visitor.Visitor;

public class CharType extends AbstractType{
    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char ";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(Type t) {
        return t instanceof CharType ? new IntegerType(this.getLine(), this.getColumn()) :
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
        return t instanceof CharType ? new IntegerType(this.getLine(), this.getColumn()) :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s can not be compared to %s", t.toString(), this ));
    }

    @Override
    public Type modulus(Type t) {
        return t instanceof CharType || t instanceof IntegerType ? new IntegerType(this.getLine(), this.getColumn()) :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s and %s can not be used for modulus operations", t.toString(), this ));
    }

    @Override
    public Type unaryMinus() {
        return new IntegerType(getLine(), getColumn());
    }

    @Override
    public Type assign(Type t){
        if( ! (t instanceof CharType)  ){
           return new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "%s and %s can not be used for assignment operations", this, t));
        }
        return this;
    }

    @Override
    public void mustBeReadable() {}
    @Override
    public void mustBeWritable() {}

    @Override
    public void returnAs(Type t){
        if( ! (t instanceof CharType)  ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "Return type must be %s ", this));
        }
    }
}
