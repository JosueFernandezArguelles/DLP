package ast.type;

import java.util.LinkedList;

public class TypeFactory {

    public static LinkedList<Type> list = new LinkedList<>();

    public static ArrayType getArray(){
        return null;
    }

    public static void add(Type t){
        list.addLast(t);
    }
}
