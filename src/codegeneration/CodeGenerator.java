package codegeneration;

import ast.expression.CharacterLiteral;
import ast.expression.DoubleLiteral;
import ast.expression.IntLiteral;
import ast.expression.Variable;
import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.type.Type;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    FileWriter outputFile;
    String code = "";

    public CodeGenerator(String outputFile){
        try {
            this.outputFile = new FileWriter(outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void arithmetic(String operator, Type type) {
        code += switch (operator) {
            case "+" -> "add" + type.suffix() + " \n";
            case "-" -> "sub" + type.suffix() + " \n";
            case "*" -> "mul" + type.suffix() + " \n";
            case "/" -> "div" + type.suffix() + " \n";
            default -> throw new UnsupportedOperationException("Wrong operation");
        };
    }

    public void modulus() {
        code += "mod";
    }

    public void comparison(String operator, Type superType) {
        code += switch(operator){
            case ">" -> "gt" + superType.suffix() + " \n";
            case "<" -> "lt" + superType.suffix() + " \n";
            case ">=" -> "ge" + superType.suffix() + " \n";
            case "<=" -> "le" + superType.suffix() + " \n";
            case "==" -> "eq" + superType.suffix() + " \n";
            case "!=" -> "ne" + superType.suffix() + " \n";
            default -> throw new UnsupportedOperationException("Wrong operation");
        };
    }

    public void logical(String operator) {
        code += switch(operator){
            case "&&" -> "and \n";
            case "||" -> "or \n";
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    public void pushAddress(Variable v) {
        VariableDefinition vd = (VariableDefinition) v.getDefinition();
        if(v.getDefinition().getScope() == 0){
            code += "pusha " + vd.getOffset() + " \n";
        } else {
            code += "push bp \n" + "pushi" + vd.getOffset() + "\n" + "addi \n";
        }
    }

    public void push(IntLiteral i) {
        code += "pushi " + i.getValue() + " \n";
    }

    public void push(DoubleLiteral d) {
        code += "pushf " + d.getValue() + " \n";
    }

    public void push(CharacterLiteral c) {
        code += "pushb " + (int) c.getValue() + " \n";
    }

    public void load(Type type) {
        code += "load" + type.suffix() + " \n";
    }

    public void convertTo(Type type, Type targetType) {
        code += type.convertTo(targetType);
    }

    public void not() {
        code += "not \n";
    }

    public void store(Type type) {
        code += "store" + type.suffix() + " \n";
    }

    public void addComment(String comment) {
        code += comment + " \n";
    }

    public void in(Type type) {
        code += "in" + type.suffix() + " \n";
    }

    public void out(Type type) {
        code += "out" + type.suffix() + " \n";
    }

    public void tag(FunctionDefinition fd) {
        code += fd.getName() + ": \n";
    }

    public void enter(int bytesLocals) {
        code += "enter " + bytesLocals + " \n";
    }

    public void ret(int bytesReturn, int bytesLocals, int bytesParameters) {
        code += "ret " + bytesReturn + "," + bytesLocals + "," + bytesParameters + " \n";
    }

    public void mainFunction() {
        code += "call main \n halt \n '* Global Variables: \n";
    }

    public void write(){
        try {
            outputFile.write(code);
            outputFile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}