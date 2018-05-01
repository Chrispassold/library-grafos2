package src.input.file;

import src.core.Vertice;
import src.exception.InvalidFormatFileException;
import src.grafos.AbstractGrafo;

import java.io.*;

abstract public class GrafoFromFile<V extends Vertice> {
    private String _arquivo;
    private AbstractGrafo<V> _grafo;

    public GrafoFromFile(AbstractGrafo<V> grafo, String _arquivo) {
        this._arquivo = _arquivo;
        this._grafo = grafo;
    }

    protected AbstractGrafo<V> getGrafo() {
        return _grafo;
    }

    public AbstractGrafo<V> loadIntoGrafo() throws IOException {
        File file = new File(this._arquivo);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo inválido");
        }
        try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {

            String line;
            boolean firstLine = true;
            while ((line = leitor.readLine()) != null) {

                String[] lineValues = line.split("[\\s+]");

                if (firstLine) {

                    if (lineValues.length != 1) {
                        throw new InvalidFormatFileException(lineValues.length);
                    }

                    getGrafo().setQuantidadeVertices(Integer.valueOf(lineValues[0]));

                    firstLine = false;
                    continue;
                }

                if (lineValues.length != 2) {
                    throw new InvalidFormatFileException(lineValues.length);
                }

                //Não dirigido
                adicionarAresta(lineValues[0], lineValues[1]);
            }
        }

        return getGrafo();
    }

    abstract public void adicionarAresta(String origem, String destino);
}
