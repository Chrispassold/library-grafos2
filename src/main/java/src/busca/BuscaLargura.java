package src.busca;

import src.core.Cor;
import src.core.Grafo;
import src.core.vertices.VerticeBuscaLargura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuscaLargura implements Busca {

    private Grafo<VerticeBuscaLargura> grafo;
    private VerticeBuscaLargura verticeInicial;
    private List<VerticeBuscaLargura> listaBusca = new ArrayList<>();

    public BuscaLargura(Grafo<VerticeBuscaLargura> grafo, VerticeBuscaLargura verticeInicial) throws RuntimeException {

        if (!grafo.existVertice(verticeInicial)) {
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
                next.setCor(Cor.Branco);
                next.setDistancia((int) Float.POSITIVE_INFINITY);
                next.setPai(null);
            }
        }

        verticeInicial.setDistancia(0);
        verticeInicial.setPai(null);
        verticeInicial.setCor(Cor.Cinza);

        listaBusca.add(verticeInicial);
    }

    @Override
    public void execute() {

        while (!listaBusca.isEmpty()) {
            VerticeBuscaLargura removido = listaBusca.remove(0);
            Iterator<VerticeBuscaLargura> verticesAdjacentes = grafo.getVerticesAdjacentes(removido);

            while (verticesAdjacentes.hasNext()) {
                VerticeBuscaLargura it = verticesAdjacentes.next();
                if (it.getCor().equals(Cor.Branco)) {
                    it.setCor(Cor.Cinza);
                    it.setDistancia(removido.getDistancia() + 1);
                    it.setPai(removido);
                    listaBusca.add(it);
                }
            }
            removido.setCor(Cor.Preto);
        }

    }

}