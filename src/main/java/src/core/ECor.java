package src.core;

public enum ECor {
    Preto(0, "PRETO"),
    Cinza(1, "CINZA"),
    Branco(2, "BRANCO");

    private int cor;
    private String corName;

    ECor(int cor, String corName) {
        this.cor = cor;
        this.corName = corName;
    }

    public int getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return corName;
    }
}
