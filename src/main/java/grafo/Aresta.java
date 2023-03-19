package grafo;

import exceptions.TamanhoDeArestaException;

public class Aresta {

    private final int tamanho;
    private final Vertice verticeA, verticeB;

    Aresta(int tamanho, Vertice verticeA, Vertice verticeB) {
        super();
        if(tamanho <= 0){
            throw new TamanhoDeArestaException();
        }
        this.tamanho = tamanho;
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    Vertice getVerticeA(){
        return verticeA;
    }

    Vertice getVerticeB(){
        return verticeB;
    }
}
