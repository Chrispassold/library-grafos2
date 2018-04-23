package src.input;

import src.exception.InvalidFormatFileException;

import java.io.*;
import java.util.*;

public class GrafoFromFile {
    private List<String> _vertices = new ArrayList<>();
    private Map<String, List<String>> _arestas = new HashMap<>();
    private int _quantidadeVertices = 0;

    public GrafoFromFile(String arquivo) throws IOException {

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

                //Não dirigido
                addAdjacente(lineValues[0], lineValues[1]);
                addAdjacente(lineValues[1], lineValues[0]);

            }
        }

    }

    private void addAdjacente(String origem, String destino) {
        if (!_vertices.contains(origem)) {
            _vertices.add(origem);
        }

        if (!_vertices.contains(destino)) {
            _vertices.add(destino);
        }

        List<String> adjacentes = _arestas.getOrDefault(origem, new ArrayList<>());

        if (!adjacentes.contains(destino)) {
            adjacentes.add(destino);
            _arestas.put(origem, adjacentes);
        }

    }


    public Iterator<String> getVertices() {
        return _vertices.iterator();
    }

    public Iterator<String> getAdjacentes(String vertice) {
        return _arestas.getOrDefault(vertice, new ArrayList<>()).iterator();
    }

    public int getQuantidadeVertices() {
        return _quantidadeVertices;
    }
}
