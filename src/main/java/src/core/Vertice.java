package src.core;

import java.security.InvalidParameterException;
import java.util.Objects;

/**
 * Classe que representa um vértice do grafo.
 */
abstract public class Vertice {
    private String valor;
    private ECor cor = ECor.Branco;

    /**
     * Cria um vértice com várias arestas.
     */
    public Vertice(String valor) {
        if (valor == null || valor.isEmpty())
            throw new InvalidParameterException(String.format("O vértice deve conter um valor válido, teve %s", String.valueOf(valor)));

        setValor(valor.toUpperCase()); //para ficar esteticamente organizado
    }

    public String getValor() {
        return valor;
    }

    private void setValor(String valor) {
        this.valor = valor;
    }

    public ECor getCor() {
        return cor;
    }

    public void setCor(ECor cor) {
        this.cor = cor;
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
        return valor;
    }
}