package ast.program;

import ast.ASTNode;
import ast.type.Type;

public interface Definition extends ASTNode {

    String getName();
    Type getType();

    int getScope();
    void setScope(int scope);
}
