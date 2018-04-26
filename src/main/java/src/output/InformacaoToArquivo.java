package src.output;

import src.core.Vertice;
import src.grafos.AbstractGrafo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;

public class InformacaoToArquivo {

    public static <V extends Vertice> void toFile(AbstractGrafo<V> grafo, String destination) throws IOException, InvalidParameterException {
        if (grafo == null) throw new InvalidParameterException("Grafo não pôde ser impresso");

        try (BufferedWriter out = new BufferedWriter(new FileWriter(destination))) {
            //Escreve o grau dos vertices
            final Iterator<Map.Entry<V, Integer>> grauVertices = grafo.getGrauVertices();
            while (grauVertices.hasNext()) {
                Map.Entry<V, Integer> next = grauVertices.next();
                out.write(String.format("Vertice %s tem grau %d", next.getKey().getValor(), next.getValue()));
                out.newLine();
            }

            //Escreve a quantidade de arestas
            out.write(String.format("Quantidade de arestas: %d", grafo.getQuantidadeArestas()));
            out.newLine();

            //Escreve a quantidade de vertices
            out.write(String.format("Quantidade de vértices: %d", grafo.getQuantidadeVertices()));

            System.out.printf("O arquivo de saída foi gerado em %s", destination);
            System.out.println();
        }
    }
}
