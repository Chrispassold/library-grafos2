package src;

import org.junit.Before;
import org.junit.Test;
import src.busca.Busca;
import src.busca.BuscaLargura;
import src.core.Grafo;
import src.core.Representacao;
import src.core.vertices.VerticeBuscaLargura;
import src.factory.GrafoFactory;
import src.input.GrafoFromFile;

import java.util.Iterator;

public class TesteBusca {

    GrafoFromFile grafoFromFile;

    @Before
    public void setup() throws Exception {
        grafoFromFile = new GrafoFromFile("grafo.in");
    }


    @Test
    public void buscaLargura() {
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

}
