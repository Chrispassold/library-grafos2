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

    public BuscaLargura(AbstractGrafo<VerticeBuscaLargura> grafo, VerticeBuscaLargura verticeInicial) throws RuntimeException {

        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        if (verticeInicial == null || !grafo.existVertice(verticeInicial)) {
            throw new RuntimeException("Vertice inicial não existe no grafo informado");
        }

        this.grafo = grafo;
        this.verticeInicial = grafo.getVertice(verticeInicial);

        inicializaGrafo();
    }

    private void inicializaGrafo() {
        Iterator<VerticeBuscaLargura> vertices = grafo.getVertices();
        while (vertices.hasNext()) {
            VerticeBuscaLargura next = vertices.next();
            if (!next.equals(verticeInicial)) {
                next.setCor(ECor.Branco);
                next.setDistancia((int) Float.POSITIVE_INFINITY);
                next.setPai(null);
            }
        }

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
        }

        finalizeTimeExecution();
    }

    @Override
    public void imprimir(String destination) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            bufferedWriter.write("--- BUSCA LARGURA ----");
            bufferedWriter.newLine();
            bufferedWriter.write(String.format("Tempo de execução: %s milisegundos", getExecutionTime()));
            bufferedWriter.newLine();
            bufferedWriter.write("Pai\tVertice\tDistancia");
            bufferedWriter.newLine();
            final String format = "%s\t%s\t%d";

            final Iterator<VerticeBuscaLargura> vertices = grafo.getVertices();

            while (vertices.hasNext()) {
                final VerticeBuscaLargura verticeBuscaLargura = vertices.next();
                bufferedWriter.write(String.format(format,
                        verticeBuscaLargura.getPai() != null ? verticeBuscaLargura.getPai().getValor() : ".",
                        verticeBuscaLargura.getValor(),
                        verticeBuscaLargura.getDistancia()));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Não foi possivel criar arquivo da busca");
            e.printStackTrace();
        }
    }

}