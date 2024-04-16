package codegeneration;

public class ValueCGVisitor {
    /*
        value[[IntLiteral: exp -> INT_C]] = <pushi>
                                            exp.value

        value[[DoubleLiteral: exp -> REAL_C]] = <pushf>
                                                exp.value

        value[[CharacterLiteral: exp -> CHAR_C]] = <pushb>
                                                   exp.value

        value[[Variable: exp -> ID]] = address[[exp]]
                                       loadi

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
                                                case "and": <and> break;
                                                case "or": <or> break;
                                             }

        value[[Negation: exp1 -> exp2]] = value[[exp2]]
                                          <not>

        value[[Cast: exp1 -> type exp2]] = value[[exp2]]
                                           exp2.type.castTo(type)

    */
}
