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
FLOATING_POINT:('.'DIGIT+)
               | ([1-9]DIGIT*'.'DIGIT*)
                ;

fragment
EXPONENT:'E'('-'|'+')DIGIT+
        |'e'DIGIT+
        ;

ID: (LETTER|'_')(LETTER|DIGIT|'_')*
            ;

CHAR_CONSTANT: '\''.'\''
                | '\'\\n\''
                | '\'\\t\''
                | '\'\\' INT_CONSTANT '\''
                ;

INT_CONSTANT:[1-9]DIGIT*
            |'0'
            ;

REAL_CONSTANT: FLOATING_POINT EXPONENT?
                |INT_CONSTANT EXPONENT
                ;

ONE_LINE_COMMENT: '//' .*? ('\n'|'\r\n'|'\r'|EOF) -> skip
            ;

MULTIPLE_LINE_COMMENT: '/*' .*? '*/' -> skip
            ;

WS: [ \t\n\r]+ -> skip
    ;