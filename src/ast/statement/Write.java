package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import java.util.List;

public class Write extends AbstractASTNode implements Statement {

    private List<Expression> expressions;
    public Write(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
    }

    public List<Expression> getExpressions(){
        return this.expressions;
    }
}
