package ast.type;

import semantic.visitor.Visitor;

public class BooleanType extends AbstractType{
    public BooleanType(int line, int column) {
        super(line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public void mustBeBoolean() {}

    @Override
    public void mustBeWritable() {}

    @Override
    public String suffix(){
        return "i";
    }

    @Override
    public Type negation() {
        return this;
    }

    @Override
    public Type logical(Type t) {

        if( t instanceof ErrorType ){
            return t;
        }

        return t instanceof BooleanType ? this :
                new ErrorType(this.getLine(), this.getColumn(),
                        String.format( "%s and %s can not be used for logical operations", t.toString(), this ));
    }

    @Override
    public String toString() {
        return "BooleanType";
    }
}
