package ast.program;

import ast.ASTNode;
import ast.AbstractASTNode;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode implements ASTNode {

    private List<Definition> definitions;
    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = new ArrayList<>(definitions);
    }

    public List<Definition> getDefinitions() {
        return this.definitions;
    }

    @Override
    public String toString() {
        return definitions.toString();
    }
}
