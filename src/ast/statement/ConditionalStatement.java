package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class ConditionalStatement extends AbstractASTNode implements Statement {

    private List<Statement> ifStatements;
    private List<Statement> elseStatements;
    private Expression condition;

    public ConditionalStatement(int line, int column, List<Statement> ifStatements, List<Statement> elseStatements,
                                Expression condition) {
        super(line, column);
        this.ifStatements = new ArrayList<>(ifStatements);
        this.elseStatements = new ArrayList<>(elseStatements);
        this.condition = condition;
    }

    public List<Statement> getIfStatements() {
        return this.ifStatements;
    }

    public List<Statement> getElseStatements() {
        return this.elseStatements;
    }

    public Expression getCondition() {
        return this.condition;
    }
}
