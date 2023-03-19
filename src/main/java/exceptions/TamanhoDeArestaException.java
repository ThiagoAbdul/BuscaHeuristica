package exceptions;

public class TamanhoDeArestaException extends RuntimeException{

    public TamanhoDeArestaException() {
        super("Comprimento da aresta não pode ser menor ou igual a 0.");
    }

}
