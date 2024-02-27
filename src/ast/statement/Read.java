package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import java.util.List;

public class Read extends AbstractASTNode implements Statement {

    private List<Expression> expressions;
    public Read(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
    }

    public List<Expression> getExpression(){
        return this.expressions;
    }
}
