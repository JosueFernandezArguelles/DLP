package visitor;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor implements Visitor<Void, Void>{

    @Override
    public Void visit(Arithmetic a, Void param) {
        a.getLeft().accept(this, param);
        a.getRight().accept(this, param);
        a.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Cast c, Void param) {
        c.getExpression().accept(this, param);
        c.getType().accept(this, param);
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharacterLiteral c, Void param) {
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparation c, Void param) {
        c.getLeft().accept(this, param);
        c.getRight().accept(this, param);
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(DoubleLiteral d, Void param) {
        d.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void param) {
        f.getExpression().accept(this, param);
        f.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation c, Void param) {
        c.getVariable().accept(this, param);
        c.getExpressionList().forEach(e -> e.accept(this, param));
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing i, Void param) {
        i.getVariable().accept(this, param);
        i.getIndex().accept(this, param);
        i.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(IntLiteral i, Void param) {
        i.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Logical l, Void param) {
        l.getLeft().accept(this, param);
        l.getRight().accept(this, param);
        l.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Modulus m, Void param) {
        m.getLeft().accept(this, param);
        m.getRight().accept(this, param);
        m.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Negation n, Void param) {
        n.getExpression().accept(this, param);
        n.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Void param) {
        u.getExpression().accept(this, param);
        u.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        v.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Program p, Void param) {
        p.getDefinitions().forEach(d -> d.accept(this, param));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition f, Void param) {
        f.getType().accept(this, param);
        f.getVariables().forEach(v -> v.accept(this, param));
        f.getStatements().forEach(s -> s.accept(this, param));
        return null;
    }

    @Override
    public Void visit(VariableDefinition v, Void param) {
        v.getType().accept(this, param);
        return null;
    }

    @Override
    public Void visit(Assignment a, Void param) {
        a.getTarget().accept(this, param);
        a.getValue().accept(this, param);
        return null;
    }

    @Override
    public Void visit(ConditionalStatement c, Void param) {
        c.getCondition().accept(this, param);
        c.getIfStatements().forEach(i -> i.accept(this, param));
        c.getElseStatements().forEach(e -> e.accept(this, param));
        return null;
    }

    @Override
    public Void visit(Read r, Void param) {
        r.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Void visit(ReturnStatement rt, Void param) {
        rt.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Void visit(While w, Void param) {
        w.getCondition().accept(this, param);
        w.getBody().forEach(b -> b.accept(this, param));
        return null;
    }

    @Override
    public Void visit(Write w, Void param) {
        w.getExpressions().accept(this, param);
        return null;
    }

    @Override
    public Void visit(ArrayType a, Void param) {
        a.getType().accept(this, param);
        return null;
    }

    @Override
    public Void visit(CharType c, Void param) {
        return null;
    }

    @Override
    public Void visit(DoubleType d, Void param) {
        return null;
    }

    @Override
    public Void visit(ErrorType e, Void param) {
        return null;
    }

    @Override
    public Void visit(Field f, Void param) {
        f.getType().accept(this, param);
        return null;
    }

    @Override
    public Void visit(FunctionType f, Void param) {
        f.getReturnType().accept(this, param);
        f.getParameters().forEach(p -> p.getType().accept(this, param));
        return null;
    }

    @Override
    public Void visit(IntegerType i, Void param) {
        return null;
    }

    @Override
    public Void visit(RecordType r, Void param) {
        r.getFields().forEach(f -> f.accept(this, param));
        return null;
    }

    @Override
    public Void visit(VoidType v, Void param) {
        return null;
    }
}
