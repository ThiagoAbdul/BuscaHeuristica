package graph;

public class Edge {

    private final Integer length;
    private final Vertex vertexA, vertexB;

    Edge(Integer length, Vertex vertexA, Vertex vertexB) {
        super();
        this.length = length;
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Integer getLength() {
        return length;
    }

    Vertex getVertexA(){
        return vertexA;
    }

    Vertex getVertexB(){
        return vertexB;
    }
}
