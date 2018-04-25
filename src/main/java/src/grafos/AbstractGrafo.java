package src.grafos;

import src.core.Grafo;
import src.core.Vertice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    public int getQuantidadeArestas() {
        int arestas = 0;
        final Iterator<Map.Entry<V, Integer>> grauVertices = getGrauVertices();
        while (grauVertices.hasNext()) {
            Map.Entry<V, Integer> next = grauVertices.next();
            arestas += next.getValue();
        }

        return arestas / 2;
    }

    @Override
    abstract public void adicionarVertice(V vertice);

    @Override
    public V getVertice(String value) {
        value = value.trim();
        final Iterator<V> vertices = getVertices();
        while (vertices.hasNext()) {
            final V vertice = vertices.next();
            if (vertice.getValor().equals(value)) {
                return vertice;
            }
        }

        return null;
    }

    @Override
    public V getVertice(Vertice value) {
        final Iterator<V> vertices = getVertices();
        while (vertices.hasNext()) {
            final V vertice = vertices.next();
            if (vertice.equals(value)) {
                return vertice;
            }
        }

        return null;
    }

    @Override
    public void adicionarAresta(V verticeOrigem, V verticeDestino) {
        final V verticeOrigemRef = getVertice(verticeOrigem);
        final V verticeDestinoRef = getVertice(verticeDestino);

        if (verticeOrigemRef != null) {
            verticeOrigem = verticeOrigemRef;
        }

        if (verticeDestinoRef != null) {
            verticeDestino = verticeDestinoRef;
        }

        adicionarArestaGrafo(verticeOrigem, verticeDestino);
    }

    abstract protected void adicionarArestaGrafo(V verticeOrigem, V verticeDestino);
}
