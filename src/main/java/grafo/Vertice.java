package grafo;

import exceptions.VerticeDesconectadoDaArestaException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Vertice {
    protected final Set<Aresta> arestas = new HashSet<>();

    public void ligarVertices(Vertice outroVertice, int tamanho){
        Aresta aresta = new Aresta(tamanho, this, outroVertice);
        this.addEdge(aresta);
        outroVertice.addEdge(aresta);
    }

    public static void ligarVertices(Vertice a, Vertice b, int tamanho){
        a.ligarVertices(b, tamanho);
    }

    private void addEdge(Aresta aresta){
        arestas.add(aresta);
    }

    public Set<? extends Vertice> getTodosVerticesLigados(){
        return arestas.stream()
                    .map(this::getVerticeLigadoPelaAresta)
                    .collect(Collectors.toSet());
    }

    protected Vertice getVerticeLigadoPelaAresta(Aresta aresta){
        if (this == aresta.getVerticeA()){
            return aresta.getVerticeB();
        }
        if(this == aresta.getVerticeB()){
            return aresta.getVerticeA();
        }
        throw new VerticeDesconectadoDaArestaException();
    }

    public int getDistanciaDoVertice(Vertice outroVertice){
        return arestas.stream()
                .filter(aresta -> getVerticeLigadoPelaAresta(aresta).equals(outroVertice))
                .findFirst()
                .orElseThrow(VerticeDesconectadoDaArestaException::new)
                .getTamanho();
    }
}
