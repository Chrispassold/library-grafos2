package src.core.vertices;

import src.core.ECor;
import src.core.Vertice;

public class VerticeBuscaLargura extends Vertice {

    private ECor cor = ECor.Branco;
    private int distancia = (int) Float.POSITIVE_INFINITY;
    private VerticeBuscaLargura pai = null;


    /**
     * Cria um vértice com várias arestas.
     *
     * @param valor valor
     */
    public VerticeBuscaLargura(String valor) {
        super(valor);
    }

    public ECor getCor() {
        return cor;
    }

    public void setCor(ECor cor) {
        this.cor = cor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public VerticeBuscaLargura getPai() {
        return pai;
    }

    public void setPai(VerticeBuscaLargura pai) {
        this.pai = pai;
    }
}
