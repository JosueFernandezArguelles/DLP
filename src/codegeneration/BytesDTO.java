package codegeneration;

public class BytesDTO {

    private int localBytes;
    private int paramBytes;
    private int returnBytes;

    public BytesDTO(int localBytes, int paramBytes, int returnBytes){
        this.localBytes = localBytes;
        this.paramBytes = paramBytes;
        this.returnBytes = returnBytes;
    }

    public int getLocalBytes() {
        return localBytes;
    }

    public int getParamBytes() {
        return paramBytes;
    }

    public int getReturnBytes() {
        return returnBytes;
    }
}
