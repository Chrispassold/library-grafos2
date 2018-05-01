package src.core.vertices;

import src.core.Vertice;

public class VerticeBuscaProfundidade extends Vertice {

    private int tempoDescoberta = (int) Float.POSITIVE_INFINITY;
    private int tempoFinalizacao = (int) Float.POSITIVE_INFINITY;
    private VerticeBuscaProfundidade pai = null;

    /**
     * Cria um vértice com várias arestas.
     *
     * @param valor valor
     */
    public VerticeBuscaProfundidade(String valor) {
        super(valor);
    }

    public int getTempoDescoberta() {
        return tempoDescoberta;
    }

    public void setTempoDescoberta(int tempoDescoberta) {
        this.tempoDescoberta = tempoDescoberta;
    }

    public int getTempoFinalizacao() {
        return tempoFinalizacao;
    }

    public void setTempoFinalizacao(int tempoFinalizacao) {
        this.tempoFinalizacao = tempoFinalizacao;
    }

    public VerticeBuscaProfundidade getPai() {
        return pai;
    }

    public void setPai(VerticeBuscaProfundidade pai) {
        this.pai = pai;
    }
}
