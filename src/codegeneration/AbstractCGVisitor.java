package codegeneration;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;
import semantic.visitor.Visitor;

public abstract class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Arithmetic a, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Cast c, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(CharacterLiteral c, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Comparation c, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(DoubleLiteral d, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(FieldAccess f, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(FunctionInvocation c, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Indexing i, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(IntLiteral i, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Logical l, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Modulus m, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Negation n, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(UnaryMinus u, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Variable v, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Program p, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(FunctionDefinition f, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(VariableDefinition v, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Assignment a, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(ConditionalStatement c, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Read r, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(ReturnStatement rt, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(While w, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Write w, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(ArrayType a, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(CharType c, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(DoubleType d, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(ErrorType e, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(Field f, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(FunctionType f, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(IntegerType i, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(RecordType r, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(VoidType v, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public TR visit(BooleanType v, TP param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

}
