grammar Cmm;

@header{
    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

program: definition* voidType 'main' '('')' functionBody
       ;

expression returns [Expression ast]: '(' e = expression ')' {$ast = $e.ast;}
          | e1 = expression '[' e2 = expression ']' {$ast = new Indexing($e1.ast.getLine(),$e1.ast.getColumn(),
                                                        $e1.ast, $e2.ast); } //indexing
          | e = expression '.' ID {$ast = new FieldAccess( $e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text );} //field access
          | OP = '(' bt = builtInType ')' e = expression { $ast = new Cast( $OP.getLine(), $OP.getCharPositionInLine()+1,
                                                            $bt.ast, $e.ast); } //Cast
          | OP = '-' e1 = expression { $ast = new UnaryMinus($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast); } //Unary minus
          | OP = '!' e1 = expression { $ast = new Negation($OP.getLine(), $OP.getCharPositionInLine()+1, $e1.ast); }//Unary not
          | e1 = expression OP = ('*'|'/'|'%') e2 = expression { $ast = ArithmeticFactory.getExpression( $e1.ast.getLine(), $e1.ast.getColumn(),
                                                                  $e1.ast, $OP.text, $e2.ast ); }  //arithmetic and modulus
          | e1 = expression OP = ('+'|'-') e2 = expression { $ast = new Arithmetic( $e1.ast.getLine(), $e1.ast.getColumn(),
                                                                $e1.ast, $OP.text, $e2.ast ); } //arithmetic
          | e1 = expression OP = ('>'|'>='|'<'|'<='|'!='|'==') e2 = expression {$ast = new Comparation( $e1.ast.getLine()
                                        , $e1.ast.getColumn(), $e1.ast, $OP.text, $e2.ast  );} // comparation
          | e1 = expression OP = ('&&'|'||') e2 = expression { $ast = new Logical($e1.ast.getLine(),$e1.ast.getColumn(),
                                            $e1.ast, $OP.text, $e2.ast); } // Logical
          | f = functionInvocation {$ast = $f.ast; }
          | IC = INT_CONSTANT { $ast = new IntLiteral( $ID.getLine(), $ID.getCharPositionInLine()+1,
                                LexerHelper.lexemeToInt( $IC.text ) ); }
          | RC = REAL_CONSTANT {$ast = new DoubleLiteral( $RC.getLine(), $RC.getCharPositionInLine()+1,
                                LexerHelper.lexemeToReal( $RC.text ) );}
          | CC = CHAR_CONSTANT { $ast = new CharacterLiteral( $CC.getLine(), $CC.getCharPositionInLine()+1,
                                    LexerHelper.lexemeToChar($CC.text)) ; }
          | ID {$ast = new Variable( $ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); } //We need to pass line and column. WHEN THEY ARE TERMINAL, WE HAVE ACCESS TO GETLINE()
          ;

statement: 'write' expressions ';' //write statement
         | 'read' expressions ';' //read statement
         | expression '=' expression ';' // assignment
         | 'while' '(' expression ')' body // while
         | 'if' '(' expression ')' body elseStatement //conditional
         | 'return' expression ';'// return
         | functionInvocation ';' //function invocation
         ;

type: type '[' INT_CONSTANT ']' //arrayType
    | builtInType
    | 'struct''{' variableDefinition* '}'//recordType
    ;

definition: variableDefinition //variable definition
          | functionDefinition //function Definition
          ;

variableDefinition: type ID (','ID)* ';' //variable definition
                  ;

elseStatement: 'else' body
             |
             ;

builtInType returns [Type ast]: INT = 'int' { $ast = new IntegerType($INT.getLine(), $INT.getCharPositionInLine()+1); }
           | D = 'double' { $ast = new DoubleType($D.getLine(), $D.getCharPositionInLine()+1); }
           | C = 'char' { $ast = new CharType($C.getLine(), $C.getCharPositionInLine()+1); }
           ;

voidType: 'void'
        ;

expressions returns [List<Expression> ast = new ArrayList<Expression>()]: e1 = expression {$ast.add($e1.ast);} (',' e2 = expression {$ast.add($e2.ast);})*
           ;

arguments returns [List<Expression> ast]: e = expressions {$ast = $e.ast;}
         |
         ;

parameters: parameter  (','parameter)*
          |
          ;

parameter: builtInType ID
         ;

body: statement
    | '{' statement* '}'
    ;

functionInvocation returns [FunctionInvocation ast] : ID '(' args = arguments ')' { $ast = new FunctionInvocation( $ID.getLine(),
                                                        $ID.getCharPositionInLine()+1,
                                                        new Variable($ID.getLine(),$ID.getCharPositionInLine()+1, $ID.text),
                                                         new ArrayList<Expression>($args.ast)); }
                   ;

functionDefinition: (builtInType|voidType) ID '(' parameters ')' functionBody
                  ;

functionBody: '{' variableDefinition* statement* '}'
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