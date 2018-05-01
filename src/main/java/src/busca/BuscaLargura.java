package src.busca;

import src.core.ECor;
import src.core.vertices.VerticeBuscaLargura;
import src.grafos.AbstractGrafo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuscaLargura extends AbstractBusca {

    private AbstractGrafo<VerticeBuscaLargura> grafo;
    private VerticeBuscaLargura verticeInicial;
    private List<VerticeBuscaLargura> listaBusca = new ArrayList<>();
    private StringBuffer _printed;

    public BuscaLargura(AbstractGrafo<VerticeBuscaLargura> grafo, VerticeBuscaLargura verticeInicial) throws RuntimeException {

        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        this.grafo = grafo;
        this.verticeInicial = grafo.getVertice(verticeInicial);

        if (this.verticeInicial == null) {
            throw new RuntimeException("Vertice inicial não existe no grafo informado");
        }

        inicializaPrinter();
        inicializaGrafo();
    }

    private void inicializaPrinter() {
        _printed = new StringBuffer();

        _printed.append("--- BUSCA LARGURA ----").append('\n');
        _printed.append("Pai\tVertice\tDistancia").append('\n');
    }

    private void printer(VerticeBuscaLargura vertice) {
        final String format = "%s\t%s\t%d";

        _printed.append(String.format(format,
                vertice.getPai() != null ? vertice.getPai().getValor() : ".",
                vertice.getValor(),
                vertice.getDistancia())).append('\n');

    }

    private void inicializaGrafo() {
        verticeInicial.setDistancia(0);
        verticeInicial.setPai(null);
        verticeInicial.setCor(ECor.Cinza);

        listaBusca.add(verticeInicial);
    }

    @Override
    public void execute() {
        initializeTimeExecution();

        while (!listaBusca.isEmpty()) {
            VerticeBuscaLargura removido = listaBusca.remove(0);
            Iterator<VerticeBuscaLargura> verticesAdjacentes = grafo.getVerticesAdjacentes(removido);

            while (verticesAdjacentes.hasNext()) {
                VerticeBuscaLargura it = verticesAdjacentes.next();
                if (it.getCor().equals(ECor.Branco)) {
                    it.setCor(ECor.Cinza);
                    it.setDistancia(removido.getDistancia() + 1);
                    it.setPai(removido);
                    listaBusca.add(it);
                }
            }
            removido.setCor(ECor.Preto);
            printer(removido);
        }

        finalizeTimeExecution();
    }

    @Override
    public void imprimir(String destination) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            bufferedWriter.write(String.format("Tempo de execução: %s", getExecutionTime()));
            bufferedWriter.newLine();
            bufferedWriter.write(_printed.toString());
        } catch (IOException e) {
            System.out.println("Não foi possivel criar arquivo da busca");
            e.printStackTrace();
        }
    }

}