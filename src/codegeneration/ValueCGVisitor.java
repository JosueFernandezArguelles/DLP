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

    */

    private CodeGenerator cg = new CodeGenerator();

    @Override
    public Void visit(IntLiteral i, Void param) {
        i.addCode("pushi " + i.getValue() + " \n");
        return null;
    }

    @Override
    public Void visit(DoubleLiteral d, Void param) {
        d.addCode("pushf " + d.getValue() + " \n");
        return null;
    }

    @Override
    public Void visit(CharacterLiteral c, Void param) {
        c.addCode("pushb " + (int) c.getValue() + " \n");
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        v.accept(new AddressCGVisitor(), param);
        v.addCode( "load" + v.getDefinition().getType().suffix() + " \n" );
        return null;
    }

    @Override
    public Void visit(Arithmetic a, Void param){
        a.getLeft().accept(this, param);
        a.addCode( a.getLeft().getType().convertTo(a.getType()));
        a.getRight().accept(this, param);
        a.addCode( a.getRight().getType().convertTo(a.getType()) );
        a.addCode( cg.arithmetic(a.getOperator(), a.getType()) );
        return null;
    }

    @Override
    public Void visit(Comparation c, Void param){
        Type superType = c.getLeft().getType().superType(c.getType());
        c.getLeft().accept(this, param);
        c.addCode( c.getLeft().getType().convertTo(superType) );
        c.getRight().accept(this, param);
        c.addCode( c.getRight().getType().convertTo(superType) );
        c.addCode( cg.comparison( c.getOperator(), superType ) );
        return null;
    }

    @Override
    public Void visit(Logical l, Void param){
        l.getLeft().accept(this, param);
        l.getRight().accept(this, param);
        l.addCode( cg.logical(l.getOperator()) );
        return null;
    }

    @Override
    public Void visit(Negation n, Void param){
        n.getExpression().accept(this, param);
        n.addCode("not \n");
        return null;
    }

    @Override
    public Void visit(Cast c, Void param){
        c.getExpression().accept(this, param);
        c.addCode( c.getExpression().getType().convertTo(c.getCastType()) );
        return null;
    }
}
