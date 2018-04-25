package src.grafos;

import src.core.Vertice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

abstract public class AbstractGrafo<V extends Vertice> {
    private int _quantidadeVertices = 0;

    public void setQuantidadeVertices(int quantidadeVertices) {
        this._quantidadeVertices = quantidadeVertices;
    }

    public int getQuantidadeVertices() {
        return _quantidadeVertices;
    }

    public int getQuantidadeArestas() {
        int arestas = 0;
        final Iterator<Map.Entry<V, Integer>> grauVertices = getGrauVertices();
        while (grauVertices.hasNext()) {
            Map.Entry<V, Integer> next = grauVertices.next();
            arestas += next.getValue();
        }

        return arestas / 2;
    }

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

    public V getVertice(V value) {
        final Iterator<V> vertices = getVertices();
        while (vertices.hasNext()) {
            final V vertice = vertices.next();
            if (vertice.equals(value)) {
                return vertice;
            }
        }

        return null;
    }

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

    public boolean existVertice(V vertice) {
        final Iterator<V> vertices = getVertices();

        while (vertices.hasNext()) {
            final V next = vertices.next();
            if (next.equals(vertice)) {
                return true;
            }
        }

        return false;
    }

    public Iterator<Map.Entry<V, Integer>> getGrauVertices() {
        Map<V, Integer> grau = new HashMap<>();
        final Iterator<V> vertices = getVertices();

        vertices.forEachRemaining(vertice -> {
            final Iterator<V> verticesAdjacentes = getVerticesAdjacentes(vertice);
            int qntAdjacentes = 0;
            while (verticesAdjacentes.hasNext()) {
                final V verticeAdj = verticesAdjacentes.next();

                if (verticeAdj.equals(vertice)) {
                    qntAdjacentes += 1;
                }

                qntAdjacentes += 1;
            }

            grau.put(vertice, qntAdjacentes);
        });

        return grau.entrySet().iterator();
    }

    abstract public void adicionarVertice(V vertice);

    abstract protected void adicionarArestaGrafo(V verticeOrigem, V verticeDestino);

    abstract public Iterator<V> getVerticesAdjacentes(V u);

    abstract public Iterator<V> getVertices();

}
