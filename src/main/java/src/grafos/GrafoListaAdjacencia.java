package src.grafos;

import src.core.Vertice;

import java.util.*;

public class GrafoListaAdjacencia extends AbstractGrafo {
    private Map<Vertice, List<Vertice>> grafo = new HashMap<>();

    @Override
    public Iterator<Vertice> getVerticesAdjacentes(Vertice vertice) {
        if (vertice != null && grafo.containsKey(vertice)) {
            return grafo.get(vertice).iterator();
        } else {
            return Collections.emptyIterator();
        }
    }

    @Override
    public Iterator<Vertice> getVertices() {
        return grafo.keySet().iterator();
    }

    @Override
    public Iterator<Map.Entry<Vertice, Integer>> getGrauVertices() {
        HashMap<Vertice, Integer> grau = new HashMap<>();

        grafo.forEach((vertice, adj) -> {
            grau.put(vertice, adj.size());
        });

        return grau.entrySet().iterator();
    }

    @Override
    public boolean existVertice(Vertice vertice) {
        for (Map.Entry<Vertice, List<Vertice>> verticeListEntry : grafo.entrySet()) {
            if (verticeListEntry.getKey().equals(vertice)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void adicionarVertice(Vertice vertice) {
        // verifica se o vertice ja esta no grafo
        if (!existVertice(vertice)) {
            grafo.put(vertice, new ArrayList<>());
        }

    }

    @Override
    public void adicionarAresta(Vertice verticeOrigem, Vertice verticeDestino) {

        if (verticeOrigem == null) {
            throw new RuntimeException("Não é possível adicionar um vertice, pois o vertice origem se encontra nulo");
        }

        adicionarVertice(verticeOrigem);

        if (verticeDestino != null) {
            final List<Vertice> adj = grafo.get(verticeOrigem);
            adj.add(verticeDestino);

            grafo.put(verticeOrigem, adj);
        }

    }
}
