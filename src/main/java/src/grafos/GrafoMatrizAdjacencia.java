package src.grafos;

import src.core.Vertice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoMatrizAdjacencia extends AbstractGrafo {

    /* Inserir Vertice: mapear no HashMap.
     * Inserir Aresta: mapear na Matriz. */
    private int _quantidadeVertices = 0;
    private int _tamanhoAtual = 0;

    Float[][] _matrizAdj = new Float[_quantidadeVertices][_quantidadeVertices];

    Map<Integer, Vertice> IntToVert = new HashMap<>();
    Map<Vertice, Integer> VertToInt = new HashMap<>();

    @Override
    public Iterator<Vertice> getVerticesAdjacentes(Vertice u) {
        return null;
    }

    @Override
    public Iterator<Vertice> getVertices() {
        return null;
    }

    @Override
    public int getQuantidadeVertices() {
        return 0;
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
