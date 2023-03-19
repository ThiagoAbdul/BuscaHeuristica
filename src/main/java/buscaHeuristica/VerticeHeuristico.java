package buscaHeuristica;

import grafo.Vertice;

public class VerticeHeuristico extends Vertice {

    private final Integer valorHeuristico;
    char letra;

    public VerticeHeuristico(char letra, int valorHeuristico) {
        super();
        this.valorHeuristico = valorHeuristico;
        this.letra = letra;
    }

    @Override
    public String toString(){
        return letra + " " + valorHeuristico;
        // TODO
    }

    public Integer getValorHeuristico(){
        return valorHeuristico;
    }

}
