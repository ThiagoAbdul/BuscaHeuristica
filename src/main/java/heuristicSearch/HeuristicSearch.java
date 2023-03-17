package heuristicSearch;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HeuristicSearch {

    private HeuristicVertex startVertex;
    private DestinationVertex endVertex;
    private final Set<HeuristicVertex> heuristicVertices = new HashSet<>();

    public HeuristicSearch(HeuristicVertex startVertex, DestinationVertex endVertex) {
        super();
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public void addHeuristicVertices(Collection<? extends HeuristicVertex> heuristicVertices){
        this.heuristicVertices.addAll(heuristicVertices);
    }
}
