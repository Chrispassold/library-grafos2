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
    private StringBuffer _printed;

    public BuscaProfundidade(AbstractGrafo<VerticeBuscaProfundidade> grafo) {

        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        this.grafo = grafo;
        inicializaPrinter();
    }

    private void inicializaPrinter() {
        _printed = new StringBuffer();

        _printed.append("--- BUSCA PROFUNDIDADE ----").append('\n');
        _printed.append("Pai\tVertice\tAberto\tFechado").append('\n');
    }

    private void printer(VerticeBuscaProfundidade vertice) {
        final String format = "%s\t%s\t%d\t%d";

        _printed.append(String.format(format,
                vertice.getPai() != null ? vertice.getPai().getValor() : ".",
                vertice.getValor(),
                vertice.getTempoDescoberta(),
                vertice.getTempoFinalizacao()
        )).append('\n');

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

        printer(vertice);
    }

    @Override
    public void imprimir(String destination) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            bufferedWriter.write(String.format("Tempo de execução: %s milisegundos", getExecutionTime()));
            bufferedWriter.newLine();
            bufferedWriter.write(_printed.toString());
        } catch (IOException e) {
            System.out.println("Não foi possivel criar arquivo da busca");
            e.printStackTrace();
        }
    }
}
