package ast;

public abstract class AbstractASTNode implements ASTNode {

    private int line;
    private int column;
    private String code = "";

    public AbstractASTNode(int line, int column){
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public String getCode(){
        return this.code;
    }

    @Override
    public void addCode(String code){
        this.code+= code;
    }
}
