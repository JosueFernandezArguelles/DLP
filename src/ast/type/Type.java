package ast.type;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {
    Type arithmetic(Type t);
    Type castTo(Type t);
    Type comparation( Type t );
    Type squareBrackets(Type t);
    Type logical(Type t);
    Type modulus(Type t);
    Type negation();
    Type unaryMinus();

    void assign(Type t);
    void mustBeReadable();
    void mustBeWritable();
    void mustBeBoolean();

    Type parenthesis( List<Type> t );
    void returnAs(Type t);
    Type dot(String id);

    int getNumberOfBytes();
}
