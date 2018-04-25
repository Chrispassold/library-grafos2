package src.input;

import src.busca.EBusca;
import src.core.ERepresentacao;
import src.core.Vertice;
import src.core.vertices.VerticeBuscaLargura;

import java.security.InvalidParameterException;

public class GrafoFromConsole {
    private String path;
    private ERepresentacao representacao;
    private EBusca busca;
    private String verticeInicial;

    public void setPath(String path) {
        this.path = path;
    }

    public void setRepresentacao(String representacao) throws InvalidParameterException {

        representacao = representacao.trim().toLowerCase();

        for (ERepresentacao value : ERepresentacao.values()) {
            if (String.valueOf(value.getRepresentacao()).equalsIgnoreCase(representacao)) {
                this.representacao = value;
                return;
            }
        }

        throw new InvalidParameterException(String.format("A representação %s não existe", representacao));
    }

    public void setBusca(String busca) throws InvalidParameterException {

        busca = busca.trim().toLowerCase();

        for (EBusca value : EBusca.values()) {
            if (String.valueOf(value.getBusca()).equalsIgnoreCase(busca)) {
                this.busca = value;
                return;
            }
        }

        throw new InvalidParameterException(String.format("A busca %s não existe", busca));
    }

    public String getPath() {
        return path;
    }

    public ERepresentacao getRepresentacao() {
        return representacao;
    }

    public EBusca getBusca() {
        return busca;
    }

    public String getVerticeInicial() {
        return verticeInicial;
    }

    public void setVerticeInicial(String verticeInicial) {
        this.verticeInicial = verticeInicial;
    }
}
