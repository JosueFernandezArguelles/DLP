package semantic.visitor;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.statement.*;
import ast.type.*;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void>{

    /*
    (P) -> DONE (1) Arithmetic: exp1 -> exp2 exp3
		   DONE (2) Indexing: exp1 -> exp2 exp3
		   DONE (3) FunctionInvocation: exp1 -> exp2 exp*
		   DONE (4) FunctionInvocation: statement -> exp2 exp*
		   DONE (5) WhileStmt: statement1 -> expression statement2*
		   DONE (6) Modulus: exp1 -> exp2 exp3
		   DONE (7) Logical: exp1 -> exp2 exp3
		   DONE (8) Negation: exp1 -> exp2
		   DONE (9) Comparation: exp1 -> exp2 exp3
		   DONE (10) UnaryMinus: exp1 -> exp2
		   DONE (11) Cast: exp1 -> type exp2
		   DONE (12) Assignment: statement -> exp1 exp2
		   DONE (13) Read: statement -> exp
		   DONE (14) Write: statement -> exp
		   DONE (15) Return: statement -> exp
		   DONE (16) FieldAccess: exp1 -> exp2 ID
		   DONE (17) IfElse: statement1 -> exp statement2* statement3*
		   DONE (18) FunctionDefinition: definition -> type ID definition* statement*
		   DONE (19) IntLiteral: exp -> INT_CONSTANT
		   DONE (20) DoubleLiteral: exp -> REAL_CONSTANT
		   DONE (21) CharLiteral: exp -> CHAR_CONSTANT
		   DONE (22) Variable: exp -> ID

    (R) ->  (1) exp1.type = exp2.type.arithmetic(exp3.type)
            (2) exp1.type = exp2.type.squareBrackets(exp3.type)
            (3) exp1.type = exp2.type.parenthesis(exp*.stream.map(e->e.type).toArray())
            (4) exp2.type.parenthesis(exp*.stream.map(e->e.type).toArray())
            (5) expression.type.mustBeBoolean()
                statement2*.forEach( s -> s.returnType = statement1.returnType )
            (6) exp1.type = exp2.type.modulus(exp3.type)
            (7) exp1.type = exp2.type.logical(exp3.type)
            (8) exp1.type = exp2.type.negation()
            (9) exp1.type = exp2.type.comparation(exp3.type)
            (10) exp1.type = exp2.type.unaryMinus()
            (11) exp1.type = exp2.type.castTo(type)
            (12) exp1.type.assign(exp2.type)
            (13) exp.type.mustBeReadable()
            (14) exp.type.mustBeWritable()
            (15) exp.type.returnAs(statement.returnType)
            (16) exp1.type = exp2.type.dot(ID)
            (17) exp.type.mustBeBoolean()
                 statement2*.forEach( s -> s.returnType = statement1.returnType )
                 statement3*.forEach( s -> s.returnType = statement1.returnType )
            (18) statement*.forEach( s -> s.returnType = type.returnType )
            (19) exp.type = new IntegerType()
            (20) exp.type = new DoubleType()
            (21) exp.type = new CharType()
            (22) exp.type = exp.definition.type //??????????????
     */

    @Override
    public Void visit(Arithmetic a, Type param) {
        super.visit(a, param);
        a.setLvalue(false);
        a.setType( a.getLeft().getType().arithmetic(a.getRight().getType()) );
        return null;
    }

    @Override
    public Void visit(Cast c, Type param) {
        super.visit(c, param);
        c.setLvalue(false);
        c.setType( c.getExpression().getType().castTo( c.getCastType() ) );
        return null;
    }

    @Override
    public Void visit(CharacterLiteral c, Type param) {
        c.setLvalue(false);
        c.setType(new CharType(c.getLine(), c.getColumn()));
        return null;
    }

    @Override
    public Void visit(Comparation c, Type param) {
        super.visit(c, param);
        c.setLvalue(false);
        c.setType( c.getLeft().getType().comparation(c.getRight().getType()) );
        return null;
    }

    @Override
    public Void visit(DoubleLiteral d, Type param) {
        d.setLvalue(false);
        d.setType(new DoubleType(d.getLine(), d.getColumn()));
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Type param) {
        super.visit(f, param);
        f.setLvalue(true);
        f.setType( f.getExpression().getType().dot(f.getFieldName()) );
        return null;
    }

    @Override
    public Void visit(FunctionInvocation c, Type param) {
        super.visit(c, param);
        c.setLvalue(false);

        List<Type> types = new ArrayList<>();

        for (Expression exp : c.getExpressionList()){
            types.add(exp.getType());
        }

        c.setType( c.getVariable().getType().parenthesis(types));
        return null;
    }

    @Override
    public Void visit(Indexing i, Type param) {
        super.visit(i, param);
        i.setLvalue(true);
        i.setType( i.getVariable().getType().squareBrackets(i.getIndex().getType()) );
        return null;
    }

    @Override
    public Void visit(IntLiteral i, Type param) {
        i.setLvalue(false);
        i.setType( new IntegerType(i.getLine(), i.getColumn()) );
        return null;
    }

    @Override
    public Void visit(Logical l, Type param) {
        super.visit(l, param);
        l.setLvalue(false);
        l.setType( l.getLeft().getType().logical(l.getRight().getType()) );
        return null;
    }

    @Override
    public Void visit(Modulus m, Type param) {
        super.visit(m, param);
        m.setLvalue(false);
        m.setType( m.getLeft().getType().modulus(m.getRight().getType()) );
        return null;
    }

    @Override
    public Void visit(Negation n, Type param) {
        super.visit(n, param);
        n.setLvalue(false);
        n.setType(n.getExpression().getType().negation());
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Type param) {
        super.visit(u, param);
        u.setLvalue(false);
        u.setType( u.getExpression().getType().unaryMinus() );
        return null;
    }

    @Override
    public Void visit(Variable v, Type param) {
        v.setLvalue(true);
        if( v.getDefinition() != null ){
            v.setType( v.getDefinition().getType() );
        } else{
            new ErrorType(v.getLine(), v.getColumn(), String.format("%s has no definition", v));
        }
        return null;
    }

    @Override
    public Void visit(Assignment a, Type param) {
        super.visit(a, param);
        if( !a.getTarget().getLvalue() ){
            new ErrorType(a.getTarget().getLine(), a.getTarget().getColumn(),
                    String.format("You can not assign %s to %s because is not l-value", a.getValue(), a.getTarget()));
        } else{
            a.getValue().getType().assign(a.getTarget().getType());
        }
        return null;
    }

    @Override
    public Void visit(Read r, Type param) {
        super.visit(r, param);
        if( !r.getExpression().getLvalue() ){
            new ErrorType(r.getExpression().getLine(), r.getExpression().getColumn(),
                    String.format("Can not read %s because is not l-value", r.getExpression()));
        } else{
            r.getExpression().getType().mustBeReadable();
        }
        return null;
    }

    @Override
    public Void visit(Write w, Type param){
        super.visit(w, param);
        w.getExpressions().getType().mustBeWritable();
        return null;
    }

    @Override
    public Void visit(While w, Type param){
        super.visit(w, param);
        w.getCondition().getType().mustBeBoolean();
        return null;
    }

    @Override
    public Void visit(ConditionalStatement c, Type param){
        super.visit(c, param);
        c.getCondition().getType().mustBeBoolean();
        return null;
    }

    @Override
    public Void visit(FunctionDefinition f, Type param){
        f.getType().accept(this, param);
        f.getVariables().forEach(v -> v.accept(this, param));
        f.getStatements().forEach( s -> s.accept(this, f.getType()) );
        return null;
    }

    @Override
    public Void visit(ReturnStatement r, Type param){
        super.visit(r, param);
        FunctionType returnType = (FunctionType) param;
        r.getExpression().accept(this, returnType.getReturnType());
        r.getExpression().setType( r.getExpression().getType().returnAs(returnType.getReturnType()) );
        return null;
    }
}