package ast.type;

import ast.AbstractASTNode;

public abstract class AbstractType extends AbstractASTNode implements Type{

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type arithmetic(Type t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be used in an arithmetic operation with %s", t.toString(), this ));
    }

    @Override
    public Type castTo(Type t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be cast to %s", this, t.toString() ));
    }

    @Override
    public Type comparation(Type t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be compared to %s", this, t.toString() ));
    }

    @Override
    public Type squareBrackets(Type t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be used for indexing", this));
    }

    @Override
    public Type logical(Type t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s and %s can not be used for logical operations", this, t));
    }

    @Override
    public Type modulus(Type t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s and %s can not be used for modulus operations", this, t));
    }

    @Override
    public Type negation(){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be used for negation operations", this));
    }

    @Override
    public Type unaryMinus(){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s can not be used for unary minus operations", this));
    }

    @Override
    public void mustBeReadable(){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s is not readable", this));
    }

    @Override
    public void mustBeWritable(){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s is not writable", this));
    }
    @Override
    public void mustBeBoolean(){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s is not boolean", this));
    }

    @Override
    public Type parenthesis(Type[] t){
        return new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s has not parenthesis operation", this));
    }
    @Override
    public void returnAs(Type t){
        new ErrorType(this.getLine(), this.getColumn(),
                String.format( "%s has not parenthesis operation", this));
    }
}
