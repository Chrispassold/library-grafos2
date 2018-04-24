package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Informe o caminho para o arquivo:");
            final String path = scanner.readLine();

            System.out.println("Qual será a representação dos grafos?");
            System.out.println("[1] Matriz de Adjacencia");
            System.out.println("[2] Lista de Adjacencia");
            final String representacaoUser = scanner.readLine();

            System.out.println("Qual será a busca a ser feita no grafo?");
            System.out.println("[1] Busca em largura");
            System.out.println("[2] Busca em profundidade");
            final String buscaUser = scanner.readLine();

        } catch (Exception exception) {
            System.out.println("Ocorreu um problema: " + exception.getMessage());
        }
    }
}