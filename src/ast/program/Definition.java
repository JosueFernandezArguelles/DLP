package ast.program;

import ast.ASTNode;
import ast.type.Type;

public interface Definition extends ASTNode {

    public String getName();
    public Type getType();

    int getScope();
    void setScope(int scope);
}
