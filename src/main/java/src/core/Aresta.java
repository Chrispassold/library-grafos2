package src.core;

/**
 * Classe que representa uma aresta do grafo.
 */
public class Aresta {

    private Vertice verticeOrigem;
    private Vertice verticeDestino;

    public Aresta(Vertice verticeOrigem, Vertice verticeDestino) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
    }

    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }
}
