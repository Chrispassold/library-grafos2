package src;

import src.core.Grafo;
import src.core.Representacao;
import src.factory.GrafoFactory;
import src.output.InformationGrafoToFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        loadGrafoLa();
        loadGrafoMa();
    }


    private static void loadGrafoLa() {
        Grafo grafoLA = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA);

        if (grafoLA == null) {
            System.out.println("Grafo lista de adjacencia nulo");
            return;
        }

        try {
            grafoLA.load("grafo.in");
            InformationGrafoToFile.toFile(grafoLA, "grafoLA.out");
        } catch (IOException e) {
            System.out.println("Grafo lista de adjacencia com problema");
            e.printStackTrace();
        }
    }

    private static void loadGrafoMa() {
        Grafo grafoMA = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA);

        if (grafoMA == null) {
            System.out.println("Grafo matriz de adjacencia nulo");
            return;
        }

        try {
            grafoMA.load("grafo.in");
            InformationGrafoToFile.toFile(grafoMA, "grafoMA.out");
        } catch (IOException e) {
            System.out.println("Grafo matriz de adjacencia com problema");
            e.printStackTrace();
        }
    }


}
