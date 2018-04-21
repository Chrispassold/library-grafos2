package src.core;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public interface Grafo {

    void mount(String arquivo) throws IOException;

    Iterator<Vertice> getVerticesAdjacentes(Vertice u);

    Iterator<Vertice> getVertices();

    int getQuantidadeVertices();

    Iterator<Map.Entry<Vertice, Integer>> getGrauVertices();

    boolean existVertice(Vertice vertice);

    void adicionarVertice(Vertice vertice);

    void adicionarAresta(Vertice verticeOrigem, Vertice verticeDestino);
}
