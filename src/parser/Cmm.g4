grammar Cmm;

@header{
    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

//TODO
program: definition* voidType 'main' '('')' functionBody
       ;

expression returns [Expression ast]:
            '(' e = expression ')'
                {$ast = $e.ast;}
          | e1 = expression '[' e2 = expression ']'
                {$ast = new Indexing($e1.ast.getLine(),$e1.ast.getColumn(),$e1.ast, $e2.ast); } //indexing
          | e = expression '.' ID
                {$ast = new FieldAccess( $e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text );} //field access
          | OP = '(' bt = builtInType ')' e = expression
                { $ast = new Cast( $OP.getLine(), $OP.getCharPositionInLine()+1, $bt.ast, $e.ast); } //Cast
          | OP = '-' e1 = expression
                { $ast = new UnaryMinus($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast); } //Unary minus
          | OP = '!' e1 = expression
                { $ast = new Negation($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast); }//Unary not
          | e1 = expression OP = ('*'|'/'|'%') e2 = expression
                { $ast = ArithmeticFactory.getExpression( $e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $OP.text, $e2.ast ); }  //arithmetic and modulus
          | e1 = expression OP = ('+'|'-') e2 = expression
                { $ast = new Arithmetic( $e1.ast.getLine(), $e1.ast.getColumn(),  $e1.ast, $OP.text, $e2.ast ); } //arithmetic
          | e1 = expression OP = ('>'|'>='|'<'|'<='|'!='|'==') e2 = expression
                {$ast = new Comparation( $e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $OP.text, $e2.ast  );} // comparation
          | e1 = expression OP = ('&&'|'||') e2 = expression
                { $ast = new Logical($e1.ast.getLine(),$e1.ast.getColumn(), $e1.ast, $OP.text, $e2.ast); } // Logical
          | f = functionInvocation
                {$ast = $f.ast; }
          | IC = INT_CONSTANT
                { $ast = new IntLiteral( $ID.getLine(), $ID.getCharPositionInLine()+1, LexerHelper.lexemeToInt( $IC.text ) ); }
          | RC = REAL_CONSTANT
                {$ast = new DoubleLiteral( $RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal( $RC.text ) );}
          | CC = CHAR_CONSTANT
                { $ast = new CharacterLiteral( $CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text)) ; }
          | ID
                {$ast = new Variable( $ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); } //We need to pass line and column. WHEN THEY ARE TERMINAL, WE HAVE ACCESS TO GETLINE()
          ;

statement returns [Statement ast]: W = 'write' e = expressions ';' //write statement
                { $ast = new Write( $W.getLine(), $W.getCharPositionInLine()+1, new ArrayList<Expression>( $e.ast )); }
         | R = 'read' e = expressions ';' //read statement
                {$ast = new Read( $R.getLine(), $R.getCharPositionInLine()+1, new ArrayList<Expression>( $e.ast ) );}
         | e1 = expression '=' e2 = expression ';' // assignment
                {$ast = new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast);}
         | W = 'while' '(' e1 = expression ')' b = body // while
                {$ast = new While( $W.getLine(), $W.getCharPositionInLine()+1, $e1.ast, $b.ast );}
         | IF = 'if' '(' e1 = expression ')' b = body el = elseStatement //conditional
                {$ast = new ConditionalStatement( $IF.getLine(), $IF.getCharPositionInLine()+1, $e1.ast, $b.ast, $el.ast );}
         | R = 'return' e1 = expression ';'// return
                {$ast = new ReturnStatement($R.getLine(), $R.getCharPositionInLine()+1, $e1.ast);}
         | f = functionInvocation ';' //function invocation
                {$ast = $f.ast;}
         ;

//TODO
type returns [Type ast]:
      t = type '[' I = INT_CONSTANT ']' //arrayType
            {$ast = new ArrayType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, LexerHelper.lexemeToInt($I.text));}
    | b = builtInType
            {$ast = $b.ast;}
    | S = 'struct''{' v = variableDefinitionList '}'//recordType
            {$ast = new RecordType($S.getLine(), $S.getCharPositionInLine()+1, $v.ast);}
    ;

//TODO
definition /*returns [Definition ast]*/:
            v = variableDefinition //variable definition
                //{$ast = $v.ast;}
          | f = functionDefinition //function Definition
                //{$ast = $f.ast; }
          ;

//TODO
variableDefinition /*returns [Field ast]*/: t = type ID (','ID)* ';' //variable definition
                  ;

//TODO
variableDefinitionList returns[ List<Field> ast = new ArrayList<Field>() ]:
                       ( variableDefinition /*{$ast.add($v.ast);}*/ ) *
                      ;

elseStatement returns [List<Statement> ast]:
              'else' body {$ast = $body.ast;}
             |
             ;

builtInType returns [Type ast]:
             I = 'int' { $ast = new IntegerType($I.getLine(), $I.getCharPositionInLine()+1); }
           | D = 'double' { $ast = new DoubleType($D.getLine(), $D.getCharPositionInLine()+1); }
           | C = 'char' { $ast = new CharType($C.getLine(), $C.getCharPositionInLine()+1); }
           ;

voidType returns [Type ast]:
         V = 'void' {$ast = new VoidType($V.getLine(), $V.getCharPositionInLine()+1);}
        ;

expressions returns [List<Expression> ast = new ArrayList<Expression>()]:
            e1 = expression {$ast.add($e1.ast);} (',' e2 = expression {$ast.add($e2.ast);})*
           ;

arguments returns [List<Expression> ast]: e = expressions {$ast = $e.ast;}
         |
         ;

parameters returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
            p1 = parameter {$ast.add($p1.ast);}  (',' p2 = parameter {$ast.add($p2.ast);})*
          |
          ;

//TODO: Offset
parameter returns [VariableDefinition ast]:
            b = builtInType ID {$ast = new VariableDefinition($b.ast.getLine(), $b.ast.getColumn(), $b.ast, $ID.text, 0);}
         ;

body returns[List<Statement> ast = new ArrayList<Statement>()]:
       s1 = statement {$ast.add($s1.ast);}
    | '{' (s2 = statement {$ast.add($s2.ast);} )* '}'
    ;

functionInvocation returns [FunctionInvocation ast] : ID '(' args = arguments ')'
                    { $ast = new FunctionInvocation( $ID.getLine(),
                       $ID.getCharPositionInLine()+1,
                       new Variable($ID.getLine(),$ID.getCharPositionInLine()+1, $ID.text),
                       new ArrayList<Expression>($args.ast)); }
                   ;

//TODO
functionDefinition returns [Definition ast]:
            t = functionType ID '(' p = parameters ')' f = functionBody
                /*{$ast = new FunctionDefinition( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID.text, $p.ast, $f.ast );}*/
          ;

functionType returns [Type ast]:
              b = builtInType {$ast = $b.ast;}
            | v = voidType {$ast = $v.ast;}
            ;

//TODO
functionBody /*returns [List<ASTNode> ast = new ArrayList<ASTNode>()]*/: //Also list of variableDefinition ?????????????????????????????????
            '{' variableDefinition /*{$ast.add($v.ast)}*/* statement /*{$ast.add($s.ast)}*/* '}'
            ;

fragment
LETTER:[a-zA-Z]
      ;

fragment
DIGIT:[0-9]
     ;

fragment
FLOATING_POINT: '.'DIGIT+
              | INT_CONSTANT'.'DIGIT*
              ;

fragment
EXPONENT:[eE]('-'|'+')?INT_CONSTANT
        ;

ID: (LETTER|'_')(LETTER|DIGIT|'_')*
  ;

CHAR_CONSTANT: '\''.'\''
             | '\'\\n\''
             | '\'\\t\''
             | '\'\\' INT_CONSTANT '\''
             ;

REAL_CONSTANT: FLOATING_POINT EXPONENT?
             | INT_CONSTANT EXPONENT
             ;

INT_CONSTANT:[1-9]DIGIT*
            |'0'
            ;

ONE_LINE_COMMENT: '//' .*? ('\n'|'\r\n'|'\r'|EOF) -> skip
                ;

MULTIPLE_LINE_COMMENT: '/*' .*? '*/' -> skip
                     ;

WS: [ \t\n\r]+ -> skip
  ;