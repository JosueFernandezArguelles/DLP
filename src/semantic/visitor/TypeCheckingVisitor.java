package semantic.visitor;

import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void>{

    @Override
    public Void visit(Arithmetic a, Void param) {
        super.visit(a, param);
        a.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Cast c, Void param) {
        super.visit(c, param);
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
        super.visit(c, param);
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
        super.visit(f, param);
        f.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation c, Void param) {
        super.visit(c, param);
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing i, Void param) {
        super.visit(i, param);
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
        super.visit(l, param);
        l.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Modulus m, Void param) {
        super.visit(m, param);
        m.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Negation n, Void param) {
        super.visit(n, param);
        n.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Void param) {
        super.visit(u, param);
        u.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        v.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment a, Void param) {
        super.visit(a, param);
        if( !a.getTarget().getLvalue() ){
            new ErrorType(a.getTarget().getLine(), a.getTarget().getColumn(),
                    String.format("You can not assign %s to %s because is not l-value", a.getValue(), a.getTarget()));
        }
        return null;
    }

    @Override
    public Void visit(Read r, Void param) {
        super.visit(r, param);
        if( !r.getExpression().getLvalue() ){
            new ErrorType(r.getExpression().getLine(), r.getExpression().getColumn(),
                    String.format("Can not read %s because is not l-value", r.getExpression()));
        }
        return null;
    }
}