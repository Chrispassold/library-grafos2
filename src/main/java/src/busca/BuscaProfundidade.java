package src.busca;

import src.core.ECor;
import src.core.vertices.VerticeBuscaProfundidade;
import src.grafos.AbstractGrafo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class BuscaProfundidade extends AbstractBusca {

    private AbstractGrafo<VerticeBuscaProfundidade> grafo;
    private int tempo = 0;

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
        initializeTimeExecution();
        final Iterator<VerticeBuscaProfundidade> vertices = grafo.getVertices();
        while (vertices.hasNext()) {
            final VerticeBuscaProfundidade vertice = vertices.next();
            if (vertice.getCor().equals(ECor.Branco)) {
                DFS(vertice);
            }
        }
        finalizeTimeExecution();
    }

    private void DFS(VerticeBuscaProfundidade vertice) {
        this.tempo = this.tempo + 1;
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
        this.tempo = this.tempo + 1;
        vertice.setTempoFinalizacao(tempo);
    }

    @Override
    public void imprimir(String destination) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            bufferedWriter.write("--- BUSCA PROFUNDIDADE ----");
            bufferedWriter.newLine();
            bufferedWriter.write(String.format("Tempo de execução: %s milisegundos", getExecutionTime()));
            bufferedWriter.newLine();
            bufferedWriter.write("Pai\tVertice\tAberto\tFechado");
            bufferedWriter.newLine();
            final String format = "%s\t%s\t%d\t%d";

            final Iterator<VerticeBuscaProfundidade> vertices = grafo.getVertices();

            while (vertices.hasNext()) {
                final VerticeBuscaProfundidade verticeBuscaProfundidade = vertices.next();
                bufferedWriter.write(String.format(format,
                        verticeBuscaProfundidade.getPai() != null ? verticeBuscaProfundidade.getPai().getValor() : ".",
                        verticeBuscaProfundidade.getValor(),
                        verticeBuscaProfundidade.getTempoDescoberta(),
                        verticeBuscaProfundidade.getTempoFinalizacao()
                ));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Não foi possivel criar arquivo da busca");
            e.printStackTrace();
        }
    }
}
