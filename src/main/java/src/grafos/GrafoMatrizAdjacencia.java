package src.grafos;

import src.core.Vertice;

import java.util.*;

public class GrafoMatrizAdjacencia extends AbstractGrafo {

    /* Inserir Vertice: mapear no HashMap.
     * Inserir Aresta: mapear na Matriz. */
    private int _tamanhoAtual = 0;

    Float[][] _matrizAdj;

    Map<Integer, Vertice> IntToVert = new HashMap<>();
    Map<Vertice, Integer> VertToInt = new HashMap<>();

    @Override
    public Iterator<Vertice> getVerticesAdjacentes(Vertice vertice) {
        if (vertice == null || !VertToInt.containsKey(vertice)) {
            return Collections.emptyIterator();
        }

        ArrayList<Vertice> adjs = new ArrayList<>();
        int key = VertToInt.get(vertice);

        for (int i = 0; i < _tamanhoAtual; i++) {
            if (_matrizAdj[key][i] != null) {
                adjs.add(IntToVert.get(i));
            }
        }

        return adjs.iterator();
    }

    @Override
    public Iterator<Vertice> getVertices() {
        return VertToInt.keySet().iterator();
    }

    @Override
    public Iterator<Map.Entry<Vertice, Integer>> getGrauVertices() {
        return null;
    }

    @Override
    public boolean existVertice(Vertice vertice) {
        return false;
    }

    @Override
    public void adicionarVertice(Vertice vertice) {

    }

    @Override
    public void adicionarAresta(Vertice verticeOrigem, Vertice verticeDestino) {

    }
}
