package ast.program;

import ast.ASTNode;
import ast.statement.Statement;
import ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition implements ASTNode {

    private List<VariableDefinition> parameters;
    private List<Statement> body;
    public FunctionDefinition(int line, int column, Type type, String name, List<VariableDefinition> parameters,
                              List<Statement> body ) {
        super(name, type, line, column);
        this.body = new ArrayList<>(body);
        this.parameters = new ArrayList<>(parameters);
    }

    public List<VariableDefinition> getParameters() {
        return this.parameters;
    }

    public List<Statement> getBody() {
        return this.body;
    }
}
