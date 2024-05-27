package codegeneration;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.type.CharType;
import ast.type.Type;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    FileWriter outputFile;
    String code = "";
    int labels = 0;

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
        code += "mod \n";
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
        assert v.getDefinition() instanceof VariableDefinition;
        VariableDefinition vd = (VariableDefinition) v.getDefinition();
        if(v.getDefinition().getScope() == 0){
            code += "pusha " + vd.getOffset() + " \n";
        } else {
            code += "push bp \n" + "pushi " + vd.getOffset() + "\n" + "addi \n";
        }
    }

    public void push(int i) {
        code += "pushi " + i + " \n";
    }

    public void push(double d) {
        code += "pushf " + d + " \n";
    }

    public void push(char c) {
        code += "pushb " + (int) c + " \n";
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
        code += "call main \nhalt \n \n'* Global Variables: \n";
    }

    public void write(){
        try {
            outputFile.write(code);
            outputFile.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String nextLabel() {
        return "label" + this.labels++;
    }

    public void addLabel(String label) {
        code += label + ": \n";
    }

    public void jumpZero(String label) {
        code += "jz " + label + "\n";
    }

    public void jump(String label) {
        code += "jmp " + label + "\n";
    }

    public void muli() {
        code += "muli  \n";
    }

    public void addi() {
        code += "addi  \n";
    }

    public void call(String name) {
        code += "call " + name + "\n";
    }

    public void pop(Type t) {
        code += "pop" + t.suffix() + "\n";
    }

    public void addLine(int line) {
        code += "\n" + "'*Line: " + line + "\n";
    }

    public void trueFalse() {
        code += "";
    }

    public void outChar() {
        code += "outb " + " \n";
    }
}