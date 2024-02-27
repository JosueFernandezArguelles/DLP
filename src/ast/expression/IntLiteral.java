package ast.expression;

import ast.AbstractASTNode;

public class IntLiteral extends AbstractASTNode implements Expression{

    private int value;
    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
