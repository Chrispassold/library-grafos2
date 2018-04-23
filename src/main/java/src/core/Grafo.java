package src.core;

import java.util.Iterator;
import java.util.Map;

public interface Grafo<V extends Vertice> {

    Iterator<V> getVerticesAdjacentes(V u);

    Iterator<V> getVertices();

    void setQuantidadeVertices(int quantidadeVertices);

    int getQuantidadeVertices();

    Iterator<Map.Entry<V, Integer>> getGrauVertices();

    boolean existVertice(V vertice);

    void adicionarVertice(V vertice);

    void adicionarAresta(V verticeOrigem, V verticeDestino);
}
