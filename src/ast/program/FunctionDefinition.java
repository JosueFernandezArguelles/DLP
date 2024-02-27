package ast.program;

import ast.ASTNode;
import ast.statement.Statement;
import ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition implements ASTNode {

    private List<VariableDefinition> variables;
    private List<Statement> statements;
    public FunctionDefinition(String name, Type type, List<Statement> statements, List<VariableDefinition> variables,
                              int line, int column) {
        super(name, type, line, column);
        this.statements = new ArrayList<>(statements);
        this.variables = new ArrayList<>(variables);
    }

    public List<VariableDefinition> getVariables() {
        return this.variables;
    }

    public List<Statement> getStatements() {
        return this.statements;
    }
}
