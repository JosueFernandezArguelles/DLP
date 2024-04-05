package ast.statement;

import ast.AbstractASTNode;
import ast.type.Type;
import semantic.visitor.Visitor;

public abstract class AbstractStatement extends AbstractASTNode implements Statement{

    public AbstractStatement(int line, int column) {
        super(line, column);
    }
}
