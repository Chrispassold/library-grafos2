package src;

import src.busca.Busca;
import src.busca.BuscaLargura;
import src.busca.BuscaProfundidade;
import src.busca.EBusca;
import src.core.ERepresentacao;
import src.core.Vertice;
import src.core.vertices.VerticeBuscaLargura;
import src.core.vertices.VerticeBuscaProfundidade;
import src.factory.GrafoFactory;
import src.grafos.AbstractGrafo;
import src.input.GrafoFromConsole;
import src.input.file.BuscaLarguraGrafoFromFile;
import src.input.file.BuscaProfundidadeGrafoFromFile;
import src.output.InformacaoToArquivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static GrafoFromConsole grafoFromConsole;

    public static void main(String[] args) {
        grafoFromConsole = new GrafoFromConsole();
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Informe o caminho para o arquivo:");
            grafoFromConsole.setPath(scanner.readLine());

            System.out.println("Qual será a representação dos grafos?");
            System.out.println(String.format("[%d] Lista de Adjacencia", ERepresentacao.LISTA_ADJACENCIA.getRepresentacao()));
            System.out.println(String.format("[%d] Matriz de Adjacencia", ERepresentacao.MATRIZ_ADJACENCIA.getRepresentacao()));
            grafoFromConsole.setRepresentacao(scanner.readLine());

            System.out.println("Qual será a busca a ser feita no grafo?");
            System.out.println(String.format("[%d] Busca em largura", EBusca.BUSCA_LARGURA.getBusca()));
            System.out.println(String.format("[%d] Busca em profundidade", EBusca.BUSCA_PROFUNDIDADE.getBusca()));
            grafoFromConsole.setBusca(scanner.readLine());

            switch (grafoFromConsole.getBusca()) {
                case BUSCA_LARGURA:
                    System.out.print("Informe o vértice inicial:");
                    grafoFromConsole.setVerticeInicial(scanner.readLine());
                    buscaLargura();
                    break;
                case BUSCA_PROFUNDIDADE:
                    buscaProfundidade();
                    break;
            }

        } catch (Exception exception) {
            System.out.println("Ocorreu um problema: " + exception.getMessage());
        }
    }

    private static void buscaLargura() throws IOException {
        final AbstractGrafo<VerticeBuscaLargura> grafo = GrafoFactory.constroiGrafo(grafoFromConsole.getRepresentacao());
        BuscaLarguraGrafoFromFile grafoFromFile = new BuscaLarguraGrafoFromFile(grafo, grafoFromConsole.getPath());
        grafoFromFile.loadIntoGrafo();

        grafoInformationToFile(grafo);

        Busca buscaLargura = new BuscaLargura(grafo, grafo.getVertice(grafoFromConsole.getVerticeInicial()));
        buscaLargura.execute();

    }

    private static void buscaProfundidade() throws IOException {
        final AbstractGrafo<VerticeBuscaProfundidade> grafo = GrafoFactory.constroiGrafo(grafoFromConsole.getRepresentacao());
        BuscaProfundidadeGrafoFromFile grafoFromFile = new BuscaProfundidadeGrafoFromFile(grafo, grafoFromConsole.getPath());
        grafoFromFile.loadIntoGrafo();

        grafoInformationToFile(grafo);

        Busca buscaLargura = new BuscaProfundidade(grafo);
        buscaLargura.execute();
    }

    private static <V extends Vertice> void grafoInformationToFile(AbstractGrafo<V> grafo) throws IOException {
        InformacaoToArquivo.toFile(grafo, "grafo.out");
    }
}