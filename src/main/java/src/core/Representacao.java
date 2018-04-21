package src.core;

public enum Representacao {
    LISTA_ADJACENCIA(0),
    MATRIZ_ADJACENCIA(1);

    private int representacao;

    Representacao(int representacao) {
        this.representacao = representacao;
    }

    public int getRepresentacao() {
        return representacao;
    }
}