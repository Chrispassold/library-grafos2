package src.input.file;

import src.core.vertices.VerticeBuscaLargura;
import src.grafos.AbstractGrafo;

public class BuscaLarguraGrafoFromFile extends GrafoFromFile<VerticeBuscaLargura> {

    public BuscaLarguraGrafoFromFile(AbstractGrafo<VerticeBuscaLargura> grafo, String _arquivo) {
        super(grafo, _arquivo);
    }

    @Override
    public void adicionarAresta(String origem, String destino) {
        AbstractGrafo<VerticeBuscaLargura> grafo = getGrafo();
        if (grafo != null) {
            VerticeBuscaLargura verticeOrigem = new VerticeBuscaLargura(origem);
            VerticeBuscaLargura verticeDestino = new VerticeBuscaLargura(destino);

            //Nao dirigido
            grafo.adicionarAresta(verticeOrigem, verticeDestino);
            grafo.adicionarAresta(verticeDestino, verticeOrigem);
        }
    }
}
