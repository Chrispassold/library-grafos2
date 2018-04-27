package src;

import org.junit.Before;
import org.junit.Test;
import src.busca.Busca;
import src.busca.BuscaLargura;
import src.busca.BuscaProfundidade;
import src.core.ERepresentacao;
import src.core.vertices.VerticeBuscaLargura;
import src.core.vertices.VerticeBuscaProfundidade;
import src.factory.GrafoFactory;
import src.grafos.AbstractGrafo;
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
        System.out.println("--- buscaLarguraLA ----");
        AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA, VerticeBuscaLargura.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        Busca buscaLargura = new BuscaLargura(grafo, new VerticeBuscaLargura("1"));
        buscaLargura.execute();
        buscaLargura.imprimir("print_buscaLarguraLA.out");
    }

    @Test
    public void buscaLarguraMA() {
        System.out.println("--- buscaLarguraMA ----");
        AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA, VerticeBuscaLargura.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        Busca buscaLargura = new BuscaLargura(grafo, new VerticeBuscaLargura("1"));
        buscaLargura.execute();
        buscaLargura.imprimir("print_buscaLarguraMA.out");
    }

    @Test
    public void buscaProfundidadeLA() {
        System.out.println("--- buscaProfundidadeLA ----");
        AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA, VerticeBuscaProfundidade.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaProfundidade(origem), new VerticeBuscaProfundidade(destino)));
        });

        Busca buscaProfundidade = new BuscaProfundidade(grafo);
        buscaProfundidade.execute();
        buscaProfundidade.imprimir("print_buscaProfundidadeLA.out");
    }

    @Test
    public void buscaProfundidadeMA() {
        System.out.println("--- buscaProfundidadeMA ----");
        AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA, VerticeBuscaProfundidade.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaProfundidade(origem), new VerticeBuscaProfundidade(destino)));
        });

        Busca buscaProfundidade = new BuscaProfundidade(grafo);
        buscaProfundidade.execute();
        buscaProfundidade.imprimir("print_buscaProfundidadeMA.out");
    }
}
