package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Vertex {
    private final Set<Edge> edges = new HashSet<>();

    public void link(Vertex other, Integer length){
        Edge edge = new Edge(length, this, other);
        this.addEdge(edge);
        other.addEdge(edge);
    }

    public static void link(Vertex a, Vertex b, Integer length){
        a.link(b, length);
    }

    private void addEdge(Edge edge){
        edges.add(edge);
    }

    public Set<Vertex> getAllLinkedVertices(){
        return edges.stream()
                    .map(this::getLinkedVertex)
                    .collect(Collectors.toSet());
    }

    private Vertex getLinkedVertex(Edge edge){
        if (this == edge.getVertexA()){
            return edge.getVertexB();
        }
        if(this == edge.getVertexB()){
            return edge.getVertexA();
        }
        throw new RuntimeException(); // TODO
    }
}
