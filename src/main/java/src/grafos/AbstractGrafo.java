package src.grafos;

import src.core.Grafo;
import src.core.Vertice;
import src.exception.InvalidFormatFileException;

import java.io.*;

abstract public class AbstractGrafo implements Grafo {
    private int _quantidadeVertices = 0;

    @Override
    public void load(String arquivo) throws IOException {
        File file = new File(arquivo);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo inválido");
        }
        try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {

            String line;
            boolean firstLine = true;
            while ((line = leitor.readLine()) != null) {

                String[] lineValues = line.split("[^\\d.]");

                if (firstLine) {

                    if (lineValues.length != 1) {
                        throw new InvalidFormatFileException(lineValues.length);
                    }

                    this._quantidadeVertices = Integer.valueOf(lineValues[0]);

                    firstLine = false;
                    continue;
                }

                if (lineValues.length != 2) {
                    throw new InvalidFormatFileException(lineValues.length);
                }

                Vertice verticeA = new Vertice(lineValues[0]);
                Vertice verticeB = new Vertice(lineValues[1]);

                // Grafo nao dirigido
                adicionarAresta(verticeA, verticeB);
                adicionarAresta(verticeB, verticeA);
            }
        }
    }

    @Override
    public int getQuantidadeVertices() {
        return _quantidadeVertices;
    }

    @Override
    abstract public void adicionarVertice(Vertice vertice);

    @Override
    abstract public void adicionarAresta(Vertice verticeOrigem, Vertice verticeDestino);
}
