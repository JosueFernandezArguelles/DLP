package ast.errorhandler;

import ast.type.ErrorType;
import ast.type.Field;

import java.util.List;

public class FieldCheck {

    public static void check(List<Field> fields, Field f){
        if(fields.contains(f)){
            new ErrorType( f.getLine(), f.getColumn(), "Repeated field" );
        } else{
            fields.add(f);
        }
    }
}
