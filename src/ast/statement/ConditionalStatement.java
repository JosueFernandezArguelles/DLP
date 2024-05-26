package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ConditionalStatement extends AbstractStatement {

    private List<Statement> ifStatements;
    private List<Statement> elseStatements;
    private Expression condition;

    public ConditionalStatement(int line, int column, Expression condition, List<Statement> ifStatements,
                                List<Statement> elseStatements) {
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

    @Override
    public String toString() {
        return "if(" + condition.toString() + ")" + ifStatements.toString() + "else" + elseStatements.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
