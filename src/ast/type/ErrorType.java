package ast.type;

import ast.AbstractASTNode;
import ast.errorhandler.ErrorHandler;
import semantic.visitor.Visitor;

public class ErrorType extends AbstractType {

    private String message;
    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.addError(this);
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "ERROR: " + message + " in " + getLine() + ":" + getColumn();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type arithmetic(Type t) {
        return this;
    }

    @Override
    public Type castTo(Type t){
        return this;
    }

    @Override
    public Type comparation(Type t) {
        return this;
    }

    @Override
    public Type logical(Type t) {
        return this;
    }

    @Override
    public Type modulus(Type t) {
        return this;
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
    public Type assign(Type t){return this;}

    @Override
    public void mustBeReadable() {}

    @Override
    public void returnAs(Type t){}
}
