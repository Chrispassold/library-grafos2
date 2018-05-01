package src;

import org.junit.Test;
import src.core.ERepresentacao;
import src.core.vertices.VerticeBuscaLargura;
import src.core.vertices.VerticeBuscaProfundidade;
import src.factory.GrafoFactory;
import src.grafos.AbstractGrafo;
import src.input.file.BuscaLarguraGrafoFromFile;
import src.input.file.BuscaProfundidadeGrafoFromFile;
import src.output.InformacaoToArquivo;

import java.io.IOException;

public class TesteInformacaoArquivo {

    private String grafoIn = "grafo.in";

    @Test
    public void InformationGrafoToFileLABL() throws IOException {
        final AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA);
        BuscaLarguraGrafoFromFile grafoFromFile = new BuscaLarguraGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        InformacaoToArquivo.toFile(grafo, "InformationGrafoToFileLABL.out");
    }

    @Test
    public void InformationGrafoToFileMABL() throws IOException {
        final AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA);
        BuscaLarguraGrafoFromFile grafoFromFile = new BuscaLarguraGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        InformacaoToArquivo.toFile(grafo, "InformationGrafoToFileMABL.out");
    }

    @Test
    public void InformationGrafoToFileLABP() throws IOException {
        final AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA);
        BuscaProfundidadeGrafoFromFile grafoFromFile = new BuscaProfundidadeGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        InformacaoToArquivo.toFile(grafo, "InformationGrafoToFileLABP.out");
    }

    @Test
    public void InformationGrafoToFileMABP() throws IOException {
        final AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(ERepresentacao.MATRIZ_ADJACENCIA);
        BuscaProfundidadeGrafoFromFile grafoFromFile = new BuscaProfundidadeGrafoFromFile(grafo, grafoIn);
        grafoFromFile.loadIntoGrafo();

        InformacaoToArquivo.toFile(grafo, "InformationGrafoToFileMABP.out");
    }
}
