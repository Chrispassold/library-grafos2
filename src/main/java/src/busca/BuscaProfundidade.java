package src.busca;

import src.core.Cor;
import src.core.Grafo;
import src.core.vertices.VerticeBuscaProfundidade;

import java.util.Iterator;

public class BuscaProfundidade implements Busca {

    private Grafo<VerticeBuscaProfundidade> grafo;
    private int tempo = 0;

    public BuscaProfundidade(Grafo<VerticeBuscaProfundidade> grafo) {

        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        this.grafo = grafo;
        inicializaGrafo();
    }

    private void inicializaGrafo() {
        final Iterator<VerticeBuscaProfundidade> vertices = grafo.getVertices();
        while (vertices.hasNext()) {
            final VerticeBuscaProfundidade vertice = vertices.next();
            vertice.setCor(Cor.Branco);
            vertice.setPai(null);
        }
    }

    @Override
    public void execute() {
        final Iterator<VerticeBuscaProfundidade> vertices = grafo.getVertices();
        while (vertices.hasNext()) {
            final VerticeBuscaProfundidade vertice = vertices.next();
            if (vertice.getCor().equals(Cor.Branco)) {
                DFS(vertice);
            }
        }
    }

    private void DFS(VerticeBuscaProfundidade vertice) {
        this.tempo++;
        vertice.setTempoDescoberta(tempo);
        vertice.setCor(Cor.Cinza);

        Iterator<VerticeBuscaProfundidade> it = grafo.getVerticesAdjacentes(vertice);
        while (it.hasNext()) {
            VerticeBuscaProfundidade v = it.next();

            if (v.getCor().equals(Cor.Branco)) {
                v.setPai(vertice);
                DFS(v);
            }
        }

        vertice.setCor(Cor.Preto);
        this.tempo++;
        vertice.setTempoFinalizacao(tempo);
    }
}
