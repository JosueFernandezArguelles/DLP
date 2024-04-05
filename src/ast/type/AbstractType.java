package ast.type;

import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type{

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%scan not be used in an arithmetic operation with %s", t.toString(), this ));
    }

    @Override
    public Type castTo(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%scan not be cast to %s", this, t.toString() ));
    }

    @Override
    public Type comparation(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be compared to %s", this, t.toString() ));
    }

    @Override
    public Type squareBrackets(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be used for indexing", this));
    }

    @Override
    public Type logical(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%sand %scan not be used for logical operations", this, t));
    }

    @Override
    public Type modulus(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%sand %scan not be used for modulus operations", this, t));
    }

    @Override
    public Type negation(){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%scan not be used for negation operations", this));
    }

    @Override
    public Type unaryMinus(){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%scan not be used for unary minus operations", this));
    }

    @Override
    public void mustBeReadable(){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%sis not readable", this));
    }

    @Override
    public void mustBeWritable(){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%sis not writable", this));
    }
    @Override
    public void mustBeBoolean(){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%sis not boolean", this));
    }

    @Override
    public Type parenthesis(List<Type> t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s has not parenthesis operation", this));
    }
    @Override
    public Type returnAs(Type t){
        if( t instanceof ErrorType ){
            return t;
        }
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be returned", this));
    }

    @Override
    public Type dot(String s){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s has not field access operation", this));
    }

    @Override
    public void assign(Type t){
        if( !(t instanceof ErrorType) ){
            new ErrorType(this.getLine(), this.getColumn(),
                    String.format( "%s can not be assign", this));
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }
}
