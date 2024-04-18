package codegeneration;

public class ExecuteCGVisitor {

    /*
        execute[[Read: statement -> expression]]= value[[expression]]
                                                  <in> expression.type.suffix()
                                                  <store> expression.type.suffix()

        execute[[Write: statement -> expression]]= value[[expression]]
                                                   <out> expression.type.suffix()

        execute[[Assignment: statement -> exp1 exp2]]= address[[exp1]]
                                                       value[[exp2]]
                                                       <store> exp1.type.suffix()

        execute[[VariableDefinition: varDefinition -> type ID]] = <'*> type.toString() ID <(offset> varDefinition.offset <)>

        execute[[FunctionDefinition: functionDefinition -> type ID variableDefinition* statement*]] =
                                                        ID <:>
                                                        execute[[type]]
                                                        <'* Local Variables:>
                                                        variableDefinition*.forEach(v -> execute[[v]])
                                                        int bytesLocals = variableDefinition*.isEmpty  ? 0 : - variableDefinition*.get(variableDefinition*.size()-1).offset
                                                        <enter> bytesLocals
                                                        int bytesParameters = type.parameters.stream().mapToInt( p -> type.noB()).sum();
                                                        int bytesReturn = type.returnType.noB()
                                                        statement*.forEach(s -> execute[[s]](bytesReturn, bytesLocals, bytesParameters))
                                                        if(type.returnType instanceof VoidType)
                                                            <ret> bytesReturn <,> bytesLocals <,> bytesParameters

        execute[[Program: program -> definition*]] = <call main>
                                                     <halt>
                                                     <'* Global Variables:>
                                                     definition*.forEach(d -> execute[[d]])
    */
}
