package src.input.file;

import src.core.vertices.VerticeBuscaProfundidade;
import src.grafos.AbstractGrafo;

public class BuscaProfundidadeGrafoFromFile extends GrafoFromFile<VerticeBuscaProfundidade> {

    public BuscaProfundidadeGrafoFromFile(AbstractGrafo<VerticeBuscaProfundidade> grafo, String _arquivo) {
        super(grafo, _arquivo);
    }

    @Override
    public void adicionarAresta(String origem, String destino) {
        AbstractGrafo<VerticeBuscaProfundidade> grafo = getGrafo();
        if (grafo != null) {
            VerticeBuscaProfundidade verticeOrigem = new VerticeBuscaProfundidade(origem);
            VerticeBuscaProfundidade verticeDestino = new VerticeBuscaProfundidade(destino);

            //Nao dirigido
            grafo.adicionarAresta(verticeOrigem, verticeDestino);
            grafo.adicionarAresta(verticeDestino, verticeOrigem);
        }
    }
}
