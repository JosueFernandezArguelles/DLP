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

        execute[[VariableDefinition: varDefinition -> type ID]] = if(varDefinition.scope == 0){

                                                                  } else{
                                                                  }

        execute[[FunctionDefinition: functionDefinition -> type ID variableDefinition* statement*]] =
                                                        ID <:>
                                                        variableDefinition*.forEach(vd -> execute[[vd]])
                                                        statement*.forEach(s -> execute[[s]])


        execute[[Program: program -> definition*]] = definition*.forEach(d -> execute[[d]])
    */
}
