package buscaHeuristica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Caminho {

    private final List<VerticeHeuristico> vertices;

    private final int custoAcumulado;

    public Caminho(List<VerticeHeuristico> vertices) {
        this.vertices = vertices;
        this.custoAcumulado = calcularCustoAcumulado();
    }

    private int calcularCustoAcumulado(){
        int acumulador = 0;
        for (int i = 0; i < vertices.size() - 1; i++){
            acumulador += vertices.get(i).getDistanciaDoVertice(vertices.get(i + 1));
        }
        return acumulador;
    }

    public Caminho(VerticeHeuristico... vertices){
        this(List.of(vertices));
    }

    public int getCustoAcumulado() {
        return custoAcumulado;
    }

    public int funcaoHeuristica(){
        VerticeHeuristico vertice = getUltimoVerticeDesteCaminho();
        return getCustoAcumulado() + vertice.getValorHeuristico();
    }

    public VerticeHeuristico getUltimoVerticeDesteCaminho(){
        return vertices.get(vertices.size() - 1);
    }

    public List<VerticeHeuristico> getTodosVerticesDoCaminho(){
        return vertices;
    }

    public boolean contemVertice(VerticeHeuristico vertice){
        return this.getTodosVerticesDoCaminho().contains(vertice);
    }

    public Caminho continuarCaminhoPeloVertice(VerticeHeuristico vertice){
        List<VerticeHeuristico> novosVertices = new ArrayList<>(vertices);
        novosVertices.add(vertice);
        return new Caminho(novosVertices);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<VerticeHeuristico> verticesIterator = vertices.iterator();
        sb.append(verticesIterator.next());
        verticesIterator.forEachRemaining(v -> sb.append(" -> ").append(v));
        return sb.toString();
    }
}
