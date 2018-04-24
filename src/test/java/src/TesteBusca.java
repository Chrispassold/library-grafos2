package src;

import org.junit.Before;
import org.junit.Test;
import src.busca.Busca;
import src.busca.BuscaLargura;
import src.busca.BuscaProfundidade;
import src.core.Grafo;
import src.core.Representacao;
import src.core.vertices.VerticeBuscaLargura;
import src.core.vertices.VerticeBuscaProfundidade;
import src.factory.GrafoFactory;
import src.input.GrafoFromFile;

import java.util.Iterator;

public class TesteBusca {

    private GrafoFromFile grafoFromFile;

    @Before
    public void setup() throws Exception {
        grafoFromFile = new GrafoFromFile("grafo.in");
    }


    @Test
    public void buscaLarguraLA() {
        Grafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA, VerticeBuscaLargura.class);
        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        Busca buscaLargura = new BuscaLargura(grafo, new VerticeBuscaLargura("1"));
        buscaLargura.execute();
    }

    @Test
    public void buscaLarguraMA() {
        Grafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA, VerticeBuscaLargura.class);
        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        Busca buscaLargura = new BuscaLargura(grafo, new VerticeBuscaLargura("1"));
        buscaLargura.execute();
    }

    @Test
    public void buscaProfundidadeLA() {
        Grafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(Representacao.LISTA_ADJACENCIA, VerticeBuscaProfundidade.class);
        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaProfundidade(origem), new VerticeBuscaProfundidade(destino)));
        });

        Busca buscaLargura = new BuscaProfundidade(grafo);
        buscaLargura.execute();
    }

    @Test
    public void buscaProfundidadeMA() {
        Grafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(Representacao.MATRIZ_ADJACENCIA, VerticeBuscaProfundidade.class);
        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaProfundidade(origem), new VerticeBuscaProfundidade(destino)));
        });

        Busca buscaLargura = new BuscaProfundidade(grafo);
        buscaLargura.execute();
    }
}
