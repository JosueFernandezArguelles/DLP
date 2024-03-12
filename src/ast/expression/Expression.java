package ast.expression;

import ast.ASTNode;

public interface Expression extends ASTNode {

    public boolean getLvalue();
    public void setLvalue(boolean lvalue);

}
