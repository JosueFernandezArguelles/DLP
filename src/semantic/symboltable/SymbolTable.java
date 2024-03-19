package semantic.symboltable;

import ast.program.Definition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private int scope = 0;
    private List<Map<String, Definition>> table;
    public SymbolTable(){
        table = new ArrayList<>();
        table.add(new HashMap<>());
    }

    public void set(){
        table.add(new HashMap<String, Definition>());
        scope++;
    }

    public void reset(){
        table.remove(scope--);
    }

    public boolean insert(Definition definition) {
        if( findInCurrentScope(definition.getName()) != null ){
            return false;
        } else{
            definition.setScope(scope);
            table.get(scope).put(definition.getName(), definition);
            return true;
        }
    }

    public Definition find(String id) {
        for (int i = scope; i >= 0; i--){
            Definition d = table.get(i).get(id);
            if( d != null ){
                return d;
            }
        }
        return null;
    }

    public Definition findInCurrentScope(String id) {
        return table.get(scope).get(id);
    }

}
