package heuristicSearch;

import graph.Vertex;

public class HeuristicVertex extends Vertex {

    private final Integer heuristicLength;
    private Integer accumalatedCost;

    public HeuristicVertex(Integer heuristicLength) {
        super();
        this.heuristicLength = heuristicLength;
    }

    @Override
    public String toString(){
        return Integer.toString(heuristicLength);
        // TODO
    }

    public Integer getHeuristicLength(){
        return heuristicLength;
    }

    public void setCostIfSmaller(Integer newCost){
        if(newCost < accumalatedCost) {
            this.accumalatedCost = newCost;
        }
    }

    public void setAccumalatedCost(Integer accumalatedCost){
        this.accumalatedCost = accumalatedCost;
    }

    public Integer calcTotalCost(){
        return accumalatedCost + heuristicLength;
    }
}
