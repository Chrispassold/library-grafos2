package src.busca;

public enum EBusca {
    BUSCA_LARGURA(0),
    BUSCA_PROFUNDIDADE(1);

    private int busca;

    EBusca(int busca) {
        this.busca = busca;
    }

    public int getBusca() {
        return busca;
    }
}
