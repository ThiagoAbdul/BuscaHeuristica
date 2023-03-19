package buscaHeuristica;

import java.util.*;
import java.util.stream.Collectors;

public class BuscaHeuristica {

    private final PriorityQueue<Caminho> caminhos;
    private Caminho melhorCaminho;

    public BuscaHeuristica(VerticeHeuristico verticeInicial) {
        super();
        caminhos = new PriorityQueue<>(Comparator.comparingInt(Caminho::funcaoHeuristica));
        caminhos.add(new Caminho(verticeInicial));
    }

    public void atualizarCaminhos(){
        Caminho removido = caminhos.remove();
        removido.getUltimoVerticeDesteCaminho()
                .getTodosVerticesLigados()
                .stream()
                .map(v -> (VerticeHeuristico) v)
                .filter(v -> caminhoNaoCausaLoop(removido, v))
                .map(removido::continuarCaminhoPeloVertice)
                .forEach(caminhos::add);
    }

    private boolean caminhoNaoCausaLoop(Caminho caminho, VerticeHeuristico vertice){
        return !caminho.contemVertice(vertice);
    }

    public void removerCaminhosObsoletos(){
        caminhos.removeIf(caminho -> {
            int custoDoCaminho = caminho.funcaoHeuristica();
            List<Integer> custos = caminhos.stream()
                    .filter(outroCaminho -> outroCaminho.contemVertice(caminho.getUltimoVerticeDesteCaminho()))
                    .map(Caminho::funcaoHeuristica)
                    .collect(Collectors.toList());
            for (var custo : custos){
                if(custo < custoDoCaminho) return true;
            }
            return false;
        });
    }

    public Caminho getMelhorCaminho(){
        if(caminhos.isEmpty()){
           return melhorCaminho;
        }
        setMelhorCaminho();
        System.out.println(caminhos);
        atualizarCaminhos();
        removerCaminhosObsoletos();
        return getMelhorCaminho();
    }

    private void setMelhorCaminho(){
        VerticeHeuristico ultimoVertice = caminhos.peek().getUltimoVerticeDesteCaminho();
        if(ultimoVertice instanceof VerticeDestino ){
            if(melhorCaminho == null) melhorCaminho = caminhos.peek();
            else {
                if(caminhos.peek().funcaoHeuristica() < melhorCaminho.funcaoHeuristica()){
                    melhorCaminho = caminhos.peek();
                }
            }
        }
    }

}
