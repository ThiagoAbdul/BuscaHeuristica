package main;

import heuristicSearch.DestinationVertex;
import heuristicSearch.HeuristicVertex;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, HeuristicVertex> heuristicVertices = new HashMap<>();
        var s = new HeuristicVertex(7);
        var a = new HeuristicVertex(10);
        var b = new HeuristicVertex(9);
        var c = new HeuristicVertex(5);
        var g = new DestinationVertex();

        s.link(a, 1);
        s.link(b, 1);
        a.link(b, 9);
        b.link(c, 6);
        b.link(g, 12);
        c.link(g, 5);

        heuristicVertices.put("s", s);
        heuristicVertices.put("a", a);
        heuristicVertices.put("b", b);
        heuristicVertices.put("c", c);
        heuristicVertices.put("g", g);

    }


}
