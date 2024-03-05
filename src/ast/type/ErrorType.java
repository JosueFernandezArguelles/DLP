package ast.type;

import ast.AbstractASTNode;
import ast.errorhandler.ErrorHandler;

public class ErrorType extends AbstractASTNode implements Type {

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
}
