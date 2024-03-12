package ast.expression;

import ast.AbstractASTNode;
import visitor.Visitor;

public class CharacterLiteral extends AbstractExpression implements Expression{

    private char value;
    public CharacterLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return "CharacterLiteral{" + value + '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
