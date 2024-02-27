package ast.expression;

import ast.AbstractASTNode;

public class CharacterLiteral extends AbstractASTNode implements Expression{

    private char value;
    public CharacterLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue(){
        return this.value;
    }
}
