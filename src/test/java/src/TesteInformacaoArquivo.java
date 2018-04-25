package src;

import org.junit.Before;
import org.junit.Test;
import src.core.Grafo;
import src.core.ERepresentacao;
import src.core.vertices.VerticeBuscaLargura;
import src.factory.GrafoFactory;
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
    public void InformationGrafoToFileTest() throws IOException {

        final Grafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(ERepresentacao.LISTA_ADJACENCIA, VerticeBuscaLargura.class);
        if (grafo == null) {
            throw new RuntimeException("Grafo nulo");
        }

        //setup grafo
        grafo.setQuantidadeVertices(grafoFromFile.getQuantidadeVertices());
        grafoFromFile.getVertices().forEachRemaining(origem -> {
            Iterator<String> adjacentes = grafoFromFile.getAdjacentes(origem);
            adjacentes.forEachRemaining(destino -> grafo.adicionarAresta(new VerticeBuscaLargura(origem), new VerticeBuscaLargura(destino)));
        });

        InformationGrafoToFile.toFile(grafo, "grafo.out");
    }
}
