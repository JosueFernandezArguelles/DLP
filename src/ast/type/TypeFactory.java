package ast.type;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class TypeFactory {

    public static ArrayType createArray(int line, int column, int size, Type previousType){
        return previousType instanceof ArrayType prev ?
                new ArrayType( line, column, createArray( line, column, size, prev.getType()), prev.getSize() ) :
                new ArrayType( line, column, previousType, size );
    }
}
