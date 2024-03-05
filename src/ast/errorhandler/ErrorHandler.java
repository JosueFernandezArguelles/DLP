package ast.errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static List<ErrorType> errors = new ArrayList<ErrorType>();
    private static ErrorHandler errorHandler = new ErrorHandler();

    private ErrorHandler(){}

    public static boolean anyErrors(){
        return !errors.isEmpty();
    }

    public static void showErrors(PrintStream out){
        for( ErrorType e : errors ){
            out.println(e.toString());
        }
    }

    public static void addError(ErrorType error){
        errors.add(error);
    }

    public static ErrorHandler getInstance(){
        return errorHandler;
    }
}
