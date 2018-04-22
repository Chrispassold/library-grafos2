package src.output;

import src.core.Grafo;
import src.core.Vertice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;

public class InformationGrafoToFile {

    public static void toFile(Grafo grafo, String destination) throws IOException, InvalidParameterException {
        if (grafo == null) throw new InvalidParameterException("Grafo não pôde ser impresso");

        try (BufferedWriter out = new BufferedWriter(new FileWriter(destination))) {
            //Inicio da contagem das arestas
            int arestas = 0;

            //Escreve o grau dos vertices
            Iterator<Map.Entry<Vertice, Integer>> grauVertices = grafo.getGrauVertices();
            while (grauVertices.hasNext()) {
                Map.Entry<Vertice, Integer> next = grauVertices.next();
                out.write(String.format("Vertice %s tem grau %d", next.getKey().getValor(), next.getValue()));
                arestas += next.getValue();
                out.newLine();
            }

            //Escreve a quantidade de arestas
            out.write(String.format("Quantidade de arestas: %d", arestas));
            out.newLine();

            //Escreve a quantidade de vertices
            out.write(String.format("Quantidade de vértices: %d", grafo.getQuantidadeVertices()));

            System.out.printf("O arquivo de saída foi gerado em %s", destination);
            System.out.println();
        }
    }
}
