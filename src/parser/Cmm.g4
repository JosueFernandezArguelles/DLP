grammar Cmm;	

program:
       ;

fragment
LETTER:[a-zA-Z]
      ;

fragment
DIGIT:[0-9]
     ;

fragment
FLOATING_POINT: '.'DIGIT+
                |INT_CONSTANT'.'DIGIT*
                ;

fragment
EXPONENT:'E'('-'|'+')INT_CONSTANT
        |'e'INT_CONSTANT
        ;

ID: (LETTER|'_')(LETTER|DIGIT|'_')*
            ;

CHAR_CONSTANT: '\''.'\''
                | '\'\\n\''
                | '\'\\t\''
                | '\'\\' INT_CONSTANT '\''
                ;

REAL_CONSTANT: FLOATING_POINT EXPONENT?
                |INT_CONSTANT EXPONENT
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