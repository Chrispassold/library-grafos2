package src.busca;

import src.core.ECor;
import src.core.vertices.VerticeBuscaProfundidade;
import src.grafos.AbstractGrafo;

import java.util.Iterator;

public class BuscaProfundidade implements Busca {

    private AbstractGrafo<VerticeBuscaProfundidade> grafo;
    private int tempo = 0;

    //impressao

    public BuscaProfundidade(AbstractGrafo<VerticeBuscaProfundidade> grafo) {

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
            vertice.setCor(ECor.Branco);
            vertice.setPai(null);
        }
    }

    @Override
    public void execute() {
        final Iterator<VerticeBuscaProfundidade> vertices = grafo.getVertices();
        while (vertices.hasNext()) {
            final VerticeBuscaProfundidade vertice = vertices.next();
            if (vertice.getCor().equals(ECor.Branco)) {
                DFS(vertice);
            }
        }

        imprimir();
    }

    @Override
    public void imprimir() {
        System.out.println("Vertice\tPai\tAberto\tFechado");
        final String format = "%s\t%s\t%d\t%d";
        grafo.getVertices().forEachRemaining(verticeBuscaProfundidade -> {
            System.out.printf(format,
                    verticeBuscaProfundidade.getValor(),
                    verticeBuscaProfundidade.getPai() != null ? verticeBuscaProfundidade.getPai().getValor() : ".",
                    verticeBuscaProfundidade.getTempoDescoberta(),
                    verticeBuscaProfundidade.getTempoFinalizacao()
            );
            System.out.println();
        });
    }

    private void DFS(VerticeBuscaProfundidade vertice) {
        this.tempo++;
        vertice.setTempoDescoberta(tempo);
        vertice.setCor(ECor.Cinza);

        Iterator<VerticeBuscaProfundidade> it = grafo.getVerticesAdjacentes(vertice);
        while (it.hasNext()) {
            VerticeBuscaProfundidade v = it.next();

            if (v.getCor().equals(ECor.Branco)) {
                v.setPai(vertice);
                DFS(v);
            }
        }

        vertice.setCor(ECor.Preto);
        this.tempo++;
        vertice.setTempoFinalizacao(tempo);
    }
}
