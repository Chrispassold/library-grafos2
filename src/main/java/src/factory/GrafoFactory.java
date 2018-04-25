package src.factory;

import src.core.Grafo;
import src.core.ERepresentacao;
import src.core.Vertice;
import src.grafos.GrafoListaAdjacencia;
import src.grafos.GrafoMatrizAdjacencia;

public class GrafoFactory implements Factory {
    public static <V extends Vertice> Grafo<V> constroiGrafo(ERepresentacao r, Class<V> clazz) throws RuntimeException {
        switch (r) {
            case LISTA_ADJACENCIA:
                return new GrafoListaAdjacencia<>();
            case MATRIZ_ADJACENCIA:
                return new GrafoMatrizAdjacencia<>();
        }

        throw new RuntimeException("Grafo nulo");
    }
}
