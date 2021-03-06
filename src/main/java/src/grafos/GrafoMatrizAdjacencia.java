package src.grafos;

import src.core.Vertice;

import java.util.*;

public class GrafoMatrizAdjacencia<V extends Vertice> extends AbstractGrafo<V> {
    private int _tamanhoAtual = 0;

    private boolean[][] _matrizAdj;

    private Map<Integer, V> IntToVert = new HashMap<>();
    private Map<V, Integer> VertToInt = new HashMap<>();

    @Override
    public void setQuantidadeVertices(int quantidadeVertices) {
        super.setQuantidadeVertices(quantidadeVertices);
        System.out.println(quantidadeVertices);
        _matrizAdj = new boolean[quantidadeVertices][quantidadeVertices];
    }

    /**
     * Função responsável por mapear um novo vertice ao HashMap.
     *
     * @param vertice vertice a ser adicionado ao HashMap
     */
    private void mapeiaVertice(V vertice) {
        if (!IntToVert.containsKey(this._tamanhoAtual) && !VertToInt.containsKey(vertice)) {
            this.IntToVert.put(_tamanhoAtual, vertice);
            this.VertToInt.put(vertice, _tamanhoAtual);
            this._tamanhoAtual++;
        }
    }

    @Override
    public Iterator<V> getVerticesAdjacentes(V vertice) {
        if (vertice == null || !VertToInt.containsKey(vertice)) {
            return Collections.emptyIterator();
        }

        ArrayList<V> adjs = new ArrayList<>();
        int key = VertToInt.get(vertice);

        for (int i = 0; i < _tamanhoAtual; i++) {
            if (_matrizAdj[key][i]) {
                adjs.add(IntToVert.get(i));
            }
        }

        return adjs.iterator();
    }

    @Override
    public Iterator<V> getVertices() {
        return VertToInt.keySet().iterator();
    }

    @Override
    public boolean existVertice(V vertice) {
        return VertToInt.containsKey(vertice);
    }

    @Override
    public void adicionarVertice(V vertice) {
        if (!existVertice(vertice)) {
            mapeiaVertice(vertice);
        }
    }

    @Override
    protected void adicionarArestaGrafo(V verticeOrigem, V verticeDestino) {
        if (verticeOrigem == null) {
            throw new RuntimeException("Não é possível adicionar um vertice, pois o vertice origem se encontra nulo");
        }

        Integer refOrigem = this.VertToInt.get(verticeOrigem);
        Integer refDestino = this.VertToInt.get(verticeDestino);

        this._matrizAdj[refOrigem][refDestino] = true;
    }

}
