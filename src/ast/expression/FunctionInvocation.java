package ast.expression;

import ast.AbstractASTNode;
import ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractASTNode implements Expression, Statement {

    private Variable variable;
    private List<Expression> expressionList;
    public FunctionInvocation(int line, int column, Variable variable, List<Expression> expressionList) {
        super(line, column);
        this.variable = variable;
        this.expressionList = new ArrayList<>(expressionList);
    }

    public Variable getVariable() {
        return this.variable;
    }

    public List<Expression> getExpressionList() {
        return this.expressionList;
    }

    @Override
    public String toString() {
        String expressions = "";
        for( Expression expression: expressionList ){
            expressions += expression.toString() + ", ";
        }

        expressions = !expressions.isEmpty() ? expressions.substring(0, expressions.length()-1) : expressions;

        return variable.toString() + "(" + expressions + ")";
    }
}
