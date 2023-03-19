package main;

import buscaHeuristica.BuscaHeuristica;
import buscaHeuristica.VerticeDestino;
import buscaHeuristica.VerticeHeuristico;

public class Main {

    public static void main(String[] args) {
        var s = new VerticeHeuristico('s', 17);
        var a = new VerticeHeuristico('a', 10);
        var b = new VerticeHeuristico('b', 13);
        var c = new VerticeHeuristico('c', 4);
        var d = new VerticeHeuristico('d', 2);
        var e = new VerticeHeuristico('e', 4);
        var f = new VerticeHeuristico('f', 1);
        var g = new VerticeDestino();

        s.ligarVertices(a, 6);
        s.ligarVertices(b, 5);
        s.ligarVertices(c, 10);
        a.ligarVertices(e, 6);
        b.ligarVertices(d, 7);
        b.ligarVertices(e, 6);
        c.ligarVertices(d, 6);
        d.ligarVertices(f, 6);
        e.ligarVertices(f, 4);
        f.ligarVertices(g, 3);

        BuscaHeuristica aEstrela = new BuscaHeuristica(s);
        System.out.println(aEstrela.getMelhorCaminho());

    }


}
