package src;

import src.core.Grafo;
import src.core.Representacao;
import src.factory.GrafoFactory;
import src.output.InformationGrafoToFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Grafo grafo = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA);

        if(grafo == null){
            throw new RuntimeException("Grafo nulo");
        }

        grafo.mount("grafo.in");
        InformationGrafoToFile.toFile(grafo, "grafo.out");
    }
}
