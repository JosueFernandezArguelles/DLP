package ast.program;

import ast.ASTNode;
import ast.statement.Statement;
import ast.type.FunctionType;
import ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private List<VariableDefinition> variables;
    private List<Statement> statements;
    public FunctionDefinition(int line, int column, FunctionType type, String name, List<VariableDefinition> variables,
                              List<Statement> statements ) {
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
