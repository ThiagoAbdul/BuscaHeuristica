package exceptions;

public class VerticeDesconectadoDaArestaException extends RuntimeException{

    public VerticeDesconectadoDaArestaException() {
        super("Vértice desconectado da aresta");
    }
}
