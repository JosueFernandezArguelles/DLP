package codegeneration;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;
import semantic.visitor.Visitor;

public abstract class AbstractCGVisitor implements Visitor<Void, Void> {

    @Override
    public Void visit(Arithmetic a, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Cast c, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(CharacterLiteral c, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Comparation c, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(DoubleLiteral d, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(FieldAccess f, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(FunctionInvocation c, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Indexing i, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(IntLiteral i, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Logical l, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Modulus m, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Negation n, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(UnaryMinus u, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Variable v, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Program p, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(FunctionDefinition f, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(VariableDefinition v, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Assignment a, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(ConditionalStatement c, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Read r, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(ReturnStatement rt, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(While w, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Write w, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(ArrayType a, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(CharType c, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(DoubleType d, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(ErrorType e, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(Field f, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(FunctionType f, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(IntegerType i, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(RecordType r, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

    @Override
    public Void visit(VoidType v, Void param) {
        String message = "Undefined template for the code function" + this.getClass().getName();
        assert false: message;
        throw new UnsupportedOperationException(message);
    }

}
