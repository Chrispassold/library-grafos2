package src.factory;

import src.core.Grafo;
import src.core.Representacao;
import src.grafos.GrafoListaAdjacencia;
import src.grafos.GrafoMatrizAdjacencia;

public class GrafoFactory implements Factory {
    public static Grafo constroiGrafo(Representacao r) {
        switch (r) {
            case LISTA_ADJACENCIA:
                return new GrafoListaAdjacencia();
            case MATRIZ_ADJACENCIA:
                return new GrafoMatrizAdjacencia();
        }

        return null;
    }
}
