package src.core;

public enum ERepresentacao {
    LISTA_ADJACENCIA(0),
    MATRIZ_ADJACENCIA(1);

    private int representacao;

    ERepresentacao(int representacao) {
        this.representacao = representacao;
    }

    public int getRepresentacao() {
        return representacao;
    }
}