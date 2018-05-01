package src;

import org.junit.Test;
import src.busca.Busca;
import src.busca.BuscaLargura;
import src.busca.BuscaProfundidade;
import src.core.ERepresentacao;
import src.core.vertices.VerticeBuscaLargura;
import src.core.vertices.VerticeBuscaProfundidade;
import src.factory.GrafoFactory;
import src.grafos.AbstractGrafo;
import src.input.file.BuscaLarguraGrafoFromFile;
import src.input.file.BuscaProfundidadeGrafoFromFile;

import java.io.IOException;

public class TesteBusca {

    private String grafoIn = "grafo.in";


    @Test
    public void buscaLarguraLA() throws IOException {
        System.out.println("--- buscaLarguraLA ----");
        AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA);

        BuscaLarguraGrafoFromFile grafoFromFile = new BuscaLarguraGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        Busca buscaLargura = new BuscaLargura(grafo, new VerticeBuscaLargura("A"));
        buscaLargura.execute();
        buscaLargura.imprimir("print_buscaLarguraLA.out");
    }

    @Test
    public void buscaLarguraMA() throws IOException {
        System.out.println("--- buscaLarguraMA ----");
        AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA);

        BuscaLarguraGrafoFromFile grafoFromFile = new BuscaLarguraGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        Busca buscaLargura = new BuscaLargura(grafo, new VerticeBuscaLargura("A"));
        buscaLargura.execute();
        buscaLargura.imprimir("print_buscaLarguraMA.out");
    }

    @Test
    public void buscaProfundidadeLA() throws IOException {
        System.out.println("--- buscaProfundidadeLA ----");
        AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA);

        BuscaProfundidadeGrafoFromFile grafoFromFile = new BuscaProfundidadeGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        Busca buscaProfundidade = new BuscaProfundidade(grafo);
        buscaProfundidade.execute();
        buscaProfundidade.imprimir("print_buscaProfundidadeLA.out");
    }

    @Test
    public void buscaProfundidadeMA() throws IOException {
        System.out.println("--- buscaProfundidadeMA ----");
        AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA);

        BuscaProfundidadeGrafoFromFile grafoFromFile = new BuscaProfundidadeGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        Busca buscaProfundidade = new BuscaProfundidade(grafo);
        buscaProfundidade.execute();
        buscaProfundidade.imprimir("print_buscaProfundidadeMA.out");
    }
}
