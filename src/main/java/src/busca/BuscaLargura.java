package src.busca;

import src.core.ECor;
import src.core.vertices.VerticeBuscaLargura;
import src.grafos.AbstractGrafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuscaLargura implements Busca {

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
        this.verticeInicial = verticeInicial;

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

    }

}