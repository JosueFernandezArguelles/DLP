grammar Cmm;

@header{
    import ast.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

program returns [Program ast]
        locals[List<Definition> list = new ArrayList<Definition>()]:
        (d = definition
            {$d.ast.forEach( def->$list.add(def) );}
        )*
         m = mainFunction
            {$list.add( $m.ast );
             $ast = new Program(0, 0, $list);
            }
         EOF
       ;

mainFunction returns [FunctionDefinition ast]:
        v = voidType M = 'main' '('')' f = functionBody
            { $ast = new FunctionDefinition( $v.ast.getLine(), $v.ast.getColumn(),
                                                new FunctionType(
                                                        $v.ast.getLine(), $v.ast.getColumn(),
                                                        $v.ast, new ArrayList<VariableDefinition>()
                                                        ),
                                                $M.text, $f.vars, $f.sts);
            }
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
                { $ast = new IntLiteral( $IC.getLine(), $IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt( $IC.text ) ); }
          | RC = REAL_CONSTANT
                {$ast = new DoubleLiteral( $RC.getLine(), $RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal( $RC.text ) );}
          | CC = CHAR_CONSTANT
                { $ast = new CharacterLiteral( $CC.getLine(), $CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar($CC.text)) ; }
          | ID
                {$ast = new Variable( $ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text); }
          ;

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
           W = 'write' e = expressions ';' //write statement
                { $e.ast.forEach( exp -> $ast.add(new Write( $W.getLine(), $W.getCharPositionInLine()+1, exp)));}
         | R = 'read' e = expressions ';' //read statement
                { $e.ast.forEach( exp -> $ast.add(new Read( $R.getLine(), $R.getCharPositionInLine()+1, exp)) ); }
         | e1 = expression '=' e2 = expression ';' // assignment
                {$ast.add( new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast));}
         | W = 'while' '(' e1 = expression ')' b = body // while
                {$ast.add( new While( $W.getLine(), $W.getCharPositionInLine()+1, $e1.ast, $b.ast ));}
         | IF = 'if' '(' e1 = expression ')' b = body el = elseStatement //conditional
                {$ast.add(new ConditionalStatement( $IF.getLine(), $IF.getCharPositionInLine()+1, $e1.ast, $b.ast, $el.ast ));}
         | R = 'return' e1 = expression ';'// return
                {$ast.add(new ReturnStatement($R.getLine(), $R.getCharPositionInLine()+1, $e1.ast));}
         | f = functionInvocation ';' //function invocation
                {$ast.add( $f.ast );}
         ;

//Todo
type returns [Type ast]:
        //locals [ LinkedList<Type> = new LinkedList() ]:
      t = type '[' I = INT_CONSTANT ']' //arrayType USE A FACTORY: int[10][20] the tree should be 10, 20, int  (adding at the end of a linked list)
            {$ast = new ArrayType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, LexerHelper.lexemeToInt($I.text));}
    | b = builtInType
            {$ast = $b.ast;}
    | S = 'struct''{' f = fields '}'//recordType
            {$ast = new RecordType($S.getLine(), $S.getCharPositionInLine()+1, $f.ast);}
    ;

fields returns [List<Field> ast = new ArrayList<Field>()]:
    (v = variableDefinitions
        {$v.ast.forEach( var -> $ast.add(new Field( var.getLine(), var.getColumn(), var.getType(), var.getName() )) );}
    )*
    ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]:
            v = variableDefinitions //variable definition
                { $v.ast.forEach( var -> $ast.add(var) );}
          | f = functionDefinition //function Definition
                {$ast.add($f.ast);}
          ;

variableDefinitions returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
            t = type ID1 = ID
                {$ast.add(new VariableDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID1.text, 0));}
             (','ID2 = ID {$ast.add(new VariableDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID2.text, 0));})* ';'
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

arguments returns [List<Expression> ast = new ArrayList<Expression>()]:
        e = expressions { $e.ast.forEach(exp -> $ast.add(exp));}
         |
         ;

parameters returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
            p1 = parameter {$ast.add($p1.ast);}  (',' p2 = parameter {$ast.add($p2.ast);})*
          |
          ;

parameter returns [VariableDefinition ast]:
            b = builtInType ID
                {$ast = new VariableDefinition($b.ast.getLine(), $b.ast.getColumn(), $b.ast, $ID.text, 0);}
         ;

body returns[List<Statement> ast = new ArrayList<Statement>()]:
       s1 = statement { $s1.ast.forEach( s -> $ast.add(s) );}
    | '{' (s2 = statement { $s2.ast.forEach( s -> $ast.add(s) );}
           )* '}'
    ;

functionInvocation returns [FunctionInvocation ast] :
                ID '(' args = arguments ')'
                    { $ast = new FunctionInvocation( $ID.getLine(),
                       $ID.getCharPositionInLine()+1,
                       new Variable($ID.getLine(),$ID.getCharPositionInLine()+1, $ID.text),
                       $args.ast); }
                   ;

functionDefinition returns [FunctionDefinition ast]:
            t = functionType b = functionBody
                {$ast = new FunctionDefinition( $t.ast.getLine(), $t.ast.getColumn(), $t.ast, $t.name, $b.vars, $b.sts );}
          ;

functionType returns [FunctionType ast, String name]:
                bov = builtInOrVoid ID '(' p = parameters ')'
                    {$ast = new FunctionType( $bov.ast.getLine(), $bov.ast.getColumn(), $bov.ast, $p.ast  );
                     $name = $ID.text;
                    }
                ;

builtInOrVoid returns [Type ast]:
               b = builtInType {$ast = $b.ast;}
             | v = voidType {$ast = $v.ast;}
            ;

functionBody returns [List<VariableDefinition> vars = new ArrayList<VariableDefinition>(),
                        List<Statement> sts = new ArrayList<Statement>()]:
            '{' (v = variableDefinitions { $v.ast.forEach( var -> $vars.add((VariableDefinition)var) ); })*
                (s = statement { $s.ast.forEach( st -> $sts.add(st));})* '}'
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