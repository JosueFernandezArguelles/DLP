package codegeneration;

import ast.expression.*;
import ast.type.Type;

public class ValueCGVisitor extends AbstractCGVisitor<Void,Void>{
    /*
        value[[IntLiteral: exp -> INT_C]] = <pushi> exp.value

        value[[DoubleLiteral: exp -> REAL_C]] = <pushf> exp.value

        value[[CharacterLiteral: exp -> CHAR_C]] = <pushb> (int) exp.value

        value[[Variable: exp -> ID]] = address[[exp]]
                                       <load> exp.variable.definition.type.suffix()

        value[[Arithmetic: exp1 -> exp2 exp3]] = value[[exp2]]
                                                 exp2.type.convertTo(exp1.type)
                                                 value[[exp3]]
                                                 exp3.type.convertTo(exp1.type)
                                                 switch (exp1.operator){
                                                    case '+': <add> exp1.type.suffix() break;
                                                    case '-': <sub> exp1.type.suffix() break;
                                                    case '*': <mul> exp1.type.suffix() break;
                                                    case '/': <div> exp1.type.suffix() break;
                                                 }

        value[[Comparison: exp1 -> exp2 exp3]]=value[[exp2]]
                                               Type superType = exp2.type.superType(exp1.type)
                                               exp2.type.convertTo( superType )
                                               value[[exp3]]
                                               exp3.type.convertTo( superType )
                                               switch(exp1.operator){
                                                   case '>': <gt> superType.suffix() break;
                                                   case '<': <lt> superType.suffix() break;
                                                   case '>=': <ge> superType.suffix() break;
                                                   case '<=': <le> superType.suffix() break;
                                                   case '==': <eq> superType.suffix() break;
                                                   case '!=': <ne> superType.suffix() break;
                                               }

        value[[Logical: exp1 -> exp2 exp3]]= value[[exp2]]
                                             value[[exp3]]
                                             switch(exp1.operator){
                                                case "&&": <and> break;
                                                case "||": <or> break;
                                             }

        value[[Negation: exp1 -> exp2]] = value[[exp2]]
                                          <not>

        value[[Cast: exp1 -> type exp2]] = value[[exp2]]
                                           exp2.type.convertTo(type)

        //Lab 12
        value[[Indexing: exp1 -> exp2 exp3]] = address[[exp1]]
                                               <load> exp1.type.suffix()

        value[[FieldAccess: exp1 -> exp2 ID]] = address[[exp1]]
                                                <load> exp1.type.suffix()


    */

    private CodeGenerator cg;

    public ValueCGVisitor(CodeGenerator cg){
        this.cg = cg;
    }

    @Override
    public Void visit(IntLiteral i, Void param) {
        cg.push(i.getValue());
        return null;
    }

    @Override
    public Void visit(DoubleLiteral d, Void param) {
        cg.push(d);
        return null;
    }

    @Override
    public Void visit(CharacterLiteral c, Void param) {
        cg.push(c);
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        v.accept(new AddressCGVisitor(cg), param);
        cg.load( v.getDefinition().getType() );
        return null;
    }

    @Override
    public Void visit(Arithmetic a, Void param){
        a.getLeft().accept(this, param);
        cg.convertTo(a.getLeft().getType(), a.getType());
        a.getRight().accept(this, param);
        cg.convertTo( a.getRight().getType(), a.getType() );
        cg.arithmetic(a.getOperator(), a.getType());
        return null;
    }

    @Override
    public Void visit(Modulus m, Void param){
        m.getLeft().accept(this, param);
        cg.convertTo(m.getLeft().getType(), m.getType());
        m.getRight().accept(this, param);
        cg.convertTo( m.getRight().getType(), m.getType() );
        cg.modulus();
        return null;
    }

    @Override
    public Void visit(Comparation c, Void param){
        Type superType = c.getLeft().getType().superType(c.getType());
        c.getLeft().accept(this, param);
        cg.convertTo( c.getLeft().getType(), superType );
        c.getRight().accept(this, param);
        cg.convertTo( c.getRight().getType(), superType );
        cg.comparison( c.getOperator(), superType );
        return null;
    }

    @Override
    public Void visit(Logical l, Void param){
        l.getLeft().accept(this, param);
        l.getRight().accept(this, param);
        cg.logical(l.getOperator());
        return null;
    }

    @Override
    public Void visit(Negation n, Void param){
        n.getExpression().accept(this, param);
        cg.not();
        return null;
    }

    @Override
    public Void visit(Cast c, Void param){
        c.getExpression().accept(this, param);
        cg.convertTo( c.getExpression().getType(), c.getCastType() );
        return null;
    }

    @Override
    public Void visit(Indexing i, Void param){
        i.accept(new AddressCGVisitor(cg), param);
        cg.load(i.getType());
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void param){
        f.accept(new AddressCGVisitor(cg), param);
        cg.load(f.getType());
        return null;
    }
}
