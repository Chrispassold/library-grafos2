package src;

import org.junit.Before;
import org.junit.Test;
import src.core.ERepresentacao;
import src.core.vertices.VerticeBuscaLargura;
import src.core.vertices.VerticeBuscaProfundidade;
import src.factory.GrafoFactory;
import src.grafos.AbstractGrafo;
import src.input.GrafoFromFile;
import src.output.InformationGrafoToFile;

import java.io.IOException;
import java.util.Iterator;

public class TesteInformacaoArquivo {

    private GrafoFromFile grafoFromFile;

    @Before
    public void setup() throws Exception {
        grafoFromFile = new GrafoFromFile("grafo.in");
    }

    @Test
    public void InformationGrafoToFileLABL() throws IOException {

        final AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA, VerticeBuscaLargura.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        InformationGrafoToFile.toFile(grafo, "InformationGrafoToFileLABL.out");
    }

    @Test
    public void InformationGrafoToFileMABL() throws IOException {

        final AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA, VerticeBuscaLargura.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        InformationGrafoToFile.toFile(grafo, "InformationGrafoToFileMABL.out");
    }

    @Test
    public void InformationGrafoToFileLABP() throws IOException {

        final AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA, VerticeBuscaProfundidade.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaProfundidade(origem), new VerticeBuscaProfundidade(destino)));
        });

        InformationGrafoToFile.toFile(grafo, "InformationGrafoToFileLABP.out");
    }

    @Test
    public void InformationGrafoToFileMABP() throws IOException {

        final AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA, VerticeBuscaProfundidade.class);

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaProfundidade(origem), new VerticeBuscaProfundidade(destino)));
        });

        InformationGrafoToFile.toFile(grafo, "InformationGrafoToFileMABP.out");
    }
}
