package src.grafos;

import src.core.Grafo;
import src.core.Vertice;

abstract public class AbstractGrafo<V extends Vertice> implements Grafo<V> {
    private int _quantidadeVertices = 0;

    @Override
    public void setQuantidadeVertices(int quantidadeVertices) {
        this._quantidadeVertices = quantidadeVertices;
    }

    @Override
    public int getQuantidadeVertices() {
        return _quantidadeVertices;
    }

    @Override
    abstract public void adicionarVertice(V vertice);

    @Override
    abstract public void adicionarAresta(V verticeOrigem, V verticeDestino);
}
