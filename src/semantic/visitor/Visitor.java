package semantic.visitor;

import ast.expression.*;
import ast.program.FunctionDefinition;
import ast.program.Program;
import ast.program.VariableDefinition;
import ast.statement.*;
import ast.type.*;

public interface Visitor <TP, TR>{

    //Expressions
    public TR visit(Arithmetic a, TP param);
    public TR visit(Cast c, TP param );
    public TR visit(CharacterLiteral c, TP param );
    public TR visit(Comparation c, TP param );
    public TR visit(DoubleLiteral d, TP param );
    public TR visit(FieldAccess f, TP param );
    public TR visit(FunctionInvocation c, TP param );
    public TR visit(Indexing i, TP param );
    public TR visit(IntLiteral i, TP param );
    public TR visit(Logical l, TP param );
    public TR visit(Modulus m, TP param );
    public TR visit(Negation n, TP param );
    public TR visit(UnaryMinus u, TP param );
    public TR visit(Variable v, TP param );

    //Program
    public TR visit(Program p, TP param );

    //Definitions
    public TR visit(FunctionDefinition f, TP param );
    public TR visit(VariableDefinition v, TP param );

    //Statements
    public TR visit(Assignment a, TP param );
    public TR visit(ConditionalStatement c, TP param );
    public TR visit(Read r, TP param );
    public TR visit(ReturnStatement rt, TP param );
    public TR visit(While w, TP param );
    public TR visit(Write w, TP param );

    //Types
    public TR visit(ArrayType a, TP param );
    public TR visit(CharType c, TP param );
    public TR visit(DoubleType d, TP param );
    public TR visit(ErrorType e, TP param );
    public TR visit(Field f, TP param );
    public TR visit(FunctionType f, TP param );
    public TR visit(IntegerType i, TP param );
    public TR visit(RecordType r, TP param );
    public TR visit(VoidType v, TP param );
}
