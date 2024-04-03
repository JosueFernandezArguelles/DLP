package semantic.visitor;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;

public abstract class AbstractVisitor<TP, TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Arithmetic a, TP param) {
        a.getLeft().accept(this, param);
        a.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast c, TP param) {
        c.getExpression().accept(this, param);
        c.getCastType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharacterLiteral c, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparation c, TP param) {
        c.getLeft().accept(this, param);
        c.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(DoubleLiteral d, TP param) {
        return null;
    }

    @Override
    public TR visit(FieldAccess f, TP param) {
        f.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation c, TP param) {
        c.getVariable().accept(this, param);
        c.getExpressionList().forEach(e -> e.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Indexing i, TP param) {
        i.getVariable().accept(this, param);
        i.getIndex().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IntLiteral i, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical l, TP param) {
        l.getLeft().accept(this, param);
        l.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Modulus m, TP param) {
        m.getLeft().accept(this, param);
        m.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Negation n, TP param) {
        n.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(UnaryMinus u, TP param) {
        u.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable v, TP param) {
        return null;
    }

    @Override
    public TR visit(Program p, TP param) {
        p.getDefinitions().forEach(d -> d.accept(this, param));
        return null;
    }

    @Override
    public TR visit(FunctionDefinition f, TP param) {
        f.getType().accept(this, param);
        f.getVariables().forEach(v -> v.accept(this, param));
        f.getStatements().forEach(s -> s.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VariableDefinition v, TP param) {
        v.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Assignment a, TP param) {
        a.getTarget().accept(this, param);
        a.getValue().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ConditionalStatement c, TP param) {
        c.getCondition().accept(this, param);
        c.getIfStatements().forEach(i -> i.accept(this, param));
        c.getElseStatements().forEach(e -> e.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Read r, TP param) {
        r.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ReturnStatement rt, TP param) {
        rt.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While w, TP param) {
        w.getCondition().accept(this, param);
        w.getBody().forEach(b -> b.accept(this, param));
        return null;
    }

    @Override
    public TR visit(Write w, TP param) {
        w.getExpressions().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayType a, TP param) {
        a.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(CharType c, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleType d, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType e, TP param) {
        return null;
    }

    @Override
    public TR visit(Field f, TP param) {
        f.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FunctionType f, TP param) {
        f.getReturnType().accept(this, param);
        f.getParameters().forEach(p -> p.accept(this, param));
        return null;
    }

    @Override
    public TR visit(IntegerType i, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordType r, TP param) {
        r.getFields().forEach(f -> f.accept(this, param));
        return null;
    }

    @Override
    public TR visit(VoidType v, TP param) {
        return null;
    }
}
