package src.grafos;

import src.core.Vertice;

import java.util.*;

public class GrafoListaAdjacencia<V extends Vertice> extends AbstractGrafo<V> {
    private Map<V, Set<V>> grafo = new HashMap<>();

    @Override
    public Iterator<V> getVerticesAdjacentes(V vertice) {
        if (vertice != null && grafo.containsKey(vertice)) {
            return grafo.get(vertice).iterator();
        } else {
            return Collections.emptyIterator();
        }
    }

    @Override
    public Iterator<V> getVertices() {
        return grafo.keySet().iterator();
    }

    @Override
    public void adicionarVertice(V vertice) {
        if (!existVertice(vertice)) {
            grafo.put(vertice, new HashSet<>());
        }

    }

    @Override
    protected void adicionarArestaGrafo(V verticeOrigem, V verticeDestino) {
        adicionarAdjacencia(verticeOrigem, verticeDestino);
    }

    private void adicionarAdjacencia(V verticeOrigem, V verticeDestino){
        if (verticeDestino != null) {
            final Set<V> adj = grafo.get(verticeOrigem);
            adj.add(verticeDestino);

            grafo.put(verticeOrigem, adj);
        }
    }
}
