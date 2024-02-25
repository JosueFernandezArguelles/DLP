grammar Cmm;

program: definition*
       ;

expression: '(' expression ')'
          | expression '[' expression ']' //indexing
          | expression '.' ID //field access
          | '(' type ')' expression //Cast
          | '-' expression //Unary minus
          | '!' expression //Unary not
          | expression ('*'|'/'|'%') expression //arithmetic and modulus
          | expression ('+'|'-') expression //arithmetic
          | expression ('>'|'>='|'<'|'<='|'!='|'==') expression // comparation
          | expression ('&&'|'||') expression // Logical
          | functionInvocation
          | INT_CONSTANT
          | REAL_CONSTANT
          | CHAR_CONSTANT
          | ID
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

builtInType: 'int'
           | 'double'
           | 'char'
           ;

voidType: 'void'
        ;

expressions: expression (',' expression)*
           ;

arguments: expressions
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

functionInvocation : ID '(' arguments ')'
                   ;

functionDefinition: voidType 'main' '('')' functionBody
                  | (builtInType|voidType) ID '(' parameters ')' functionBody
                  ;

functionBody: '{' variableDefinition* statement* '}' //???????????????????
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