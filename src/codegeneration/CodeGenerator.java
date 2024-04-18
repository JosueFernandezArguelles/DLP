package codegeneration;

import ast.type.Type;

public class CodeGenerator {
    public String arithmetic(String operator, Type type) {
        return switch (operator) {
            case "+" -> "add" + type.suffix() + " \n";
            case "-" -> "sub" + type.suffix() + " \n";
            case "*" -> "mul" + type.suffix() + " \n";
            case "/" -> "div" + type.suffix() + " \n";
            default -> throw new UnsupportedOperationException("Wrong operation");
        };
    }

    public String comparison(String operator, Type superType) {
        return switch(operator){
            case ">" -> "gt" + superType.suffix() + " \n";
            case "<" -> "lt" + superType.suffix() + " \n";
            case ">=" -> "ge" + superType.suffix() + " \n";
            case "<=" -> "le" + superType.suffix() + " \n";
            case "==" -> "eq" + superType.suffix() + " \n";
            case "!=" -> "ne" + superType.suffix() + " \n";
            default -> throw new UnsupportedOperationException("Wrong operation");
        };
    }

    public String logical(String operator) {
        return switch(operator){
            case "&&" -> "and \n";
            case "||" -> "or \n";
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
