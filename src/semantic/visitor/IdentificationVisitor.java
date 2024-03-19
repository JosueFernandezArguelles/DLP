package semantic.visitor;

import ast.expression.Variable;
import ast.program.Definition;
import ast.program.FunctionDefinition;
import ast.program.VariableDefinition;
import ast.type.ErrorType;
import ast.type.FunctionType;
import semantic.symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void>{

    private SymbolTable table = new SymbolTable();

    @Override
    public Void visit(Variable v, Void param) {
        Definition d = table.find(v.getName());
        if(d == null){
            new ErrorType(v.getLine(), v.getColumn(),
                    String.format( "Variable %s has not been declared", v.getName()));

        } else{
            v.setDefinition(d);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition f, Void param) {

        //Function name
        if(!table.insert(f)){
            new ErrorType(f.getLine(), f.getColumn(),
                    String.format( "Function %s already declared in current scope in line %s", f.getName(), table.find(f.getName()).getLine() ));
        }
        table.set();
        f.getType().accept(this, param);
        //Body
        f.getVariables().forEach( v -> v.accept(this, param) );
        f.getStatements().forEach( s -> s.accept(this, param) );
        table.reset();
        return null;
    }

    @Override
    public Void visit(FunctionType f, Void param) {
        for( VariableDefinition vd : f.getParameters() ){
            table.insert(vd);
        }
        return super.visit(f, param);
    }

    @Override
    public Void visit(VariableDefinition v, Void param) {
        super.visit(v, param);
        if(!table.insert(v)){
            new ErrorType(v.getLine(), v.getColumn(),
                    String.format( "Variable %s already declared in current scope in line %s", v.getName(), table.find(v.getName()).getLine() ));
        }
        return null;
    }
}
