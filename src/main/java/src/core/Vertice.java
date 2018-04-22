package src.core;

import java.security.InvalidParameterException;
import java.util.Objects;

/**
 * Classe que representa um vértice do grafo.
 */
public class Vertice {
    private String valor;

    /**
     * Cria um vértice com várias arestas.
     */
    public Vertice(String valor) {
        if (valor == null || valor.isEmpty())
            throw new InvalidParameterException(String.format("O vértice deve conter um valor válido, teve %s", String.valueOf(valor)));

        this.valor = valor.toUpperCase(); //para ficar esteticamente organizado
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj instanceof Vertice) {
            return this.valor.equalsIgnoreCase(((Vertice) obj).getValor());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getValor());
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "valor='" + valor + '\'' +
                '}';
    }
}