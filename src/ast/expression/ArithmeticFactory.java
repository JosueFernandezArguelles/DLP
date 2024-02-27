package ast.expression;

import parser.LexerHelper;

public class ArithmeticFactory {

    public static Expression getExpression(int line, int column, Expression e1, String op, Expression e2){
        return LexerHelper.lexemeToChar(op) == '%' ?
                new Modulus(line, column,e1, e2) :
                new Arithmetic(line, column, e1, op, e2);
    }
}
