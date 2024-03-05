package ast.type;

import ast.AbstractASTNode;

public class ErrorType extends AbstractASTNode implements Type {

    private String message;
    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "ERROR: " + message + "in " + getLine() + ":" + getColumn();
    }
}
