package src.grafos;

import src.core.Vertice;

import java.util.*;

public class GrafoListaAdjacencia<V extends Vertice> extends AbstractGrafo<V> {
    private Map<V, List<V>> grafo = new HashMap<>();

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
    public Iterator<Map.Entry<V, Integer>> getGrauVertices() {
        HashMap<V, Integer> grau = new HashMap<>();

        grafo.forEach((vertice, adj) -> {
            int grauVertice = 0;
            for (V verticeAdj : adj) {
                //Loop
                if (verticeAdj.equals(vertice)) {
                    grauVertice += 1;
                }

                grauVertice += 1;
            }

            grau.put(vertice, grauVertice);
        });

        return grau.entrySet().iterator();
    }

    @Override
    public void adicionarVertice(V vertice) {
        // verifica se o vertice ja esta no grafo
        if (!existVertice(vertice)) {
            grafo.put(vertice, new ArrayList<>());
        }

    }

    @Override
    protected void adicionarArestaGrafo(V verticeOrigem, V verticeDestino) {

        if (verticeOrigem == null) {
            throw new RuntimeException("Não é possível adicionar um vertice, pois o vertice origem se encontra nulo");
        }

        adicionarVertice(verticeOrigem);

        if (verticeDestino != null) {
            final List<V> adj = grafo.get(verticeOrigem);
            adj.add(verticeDestino);

            grafo.put(verticeOrigem, adj);
        }

    }
}
