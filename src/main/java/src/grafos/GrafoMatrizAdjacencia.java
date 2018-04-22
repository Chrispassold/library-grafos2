package src.grafos;

import src.core.Vertice;

import java.util.*;

public class GrafoMatrizAdjacencia extends AbstractGrafo {

    /* Inserir Vertice: mapear no HashMap.
     * Inserir Aresta: mapear na Matriz. */
    private int _tamanhoAtual = 0;

    private Integer[][] _matrizAdj;

    private Map<Integer, Vertice> IntToVert = new HashMap<>();
    private Map<Vertice, Integer> VertToInt = new HashMap<>();


    @Override
    public void setQuantidadeVertices(int quantidadeVertices) {
        super.setQuantidadeVertices(quantidadeVertices);
        _matrizAdj = new Integer[quantidadeVertices][quantidadeVertices];
    }

    /**
     * Função responsável por mapear um novo vertice ao HashMap.
     *
     * @param vertice vertice a ser adicionado ao HashMap
     */
    private void mapeiaVertice(Vertice vertice) {
        if (!IntToVert.containsKey(this._tamanhoAtual) && !VertToInt.containsKey(vertice)) {
            this.IntToVert.put(_tamanhoAtual, vertice);
            this.VertToInt.put(vertice, _tamanhoAtual);
            this._tamanhoAtual++;
        }
    }

    @Override
    public Iterator<Vertice> getVerticesAdjacentes(Vertice vertice) {
        if (vertice == null || !VertToInt.containsKey(vertice)) {
            return Collections.emptyIterator();
        }

        ArrayList<Vertice> adjs = new ArrayList<>();
        int key = VertToInt.get(vertice);

        for (int i = 0; i < _tamanhoAtual; i++) {
            if (_matrizAdj[key][i] != null) {
                adjs.add(IntToVert.get(i));
            }
        }

        return adjs.iterator();
    }

    @Override
    public Iterator<Vertice> getVertices() {
        return VertToInt.keySet().iterator();
    }

    @Override
    public Iterator<Map.Entry<Vertice, Integer>> getGrauVertices() {
        HashMap<Vertice, Integer> grau = new HashMap<>();
        VertToInt.forEach((vertice, adj) -> {

            Iterator<Vertice> verticesAdjacentes = getVerticesAdjacentes(vertice);
            int qntAdjacentes = 0;
            while (verticesAdjacentes.hasNext()) {
                verticesAdjacentes.next();
                qntAdjacentes++;
            }

            grau.put(vertice, qntAdjacentes);
        });

        return grau.entrySet().iterator();
    }

    @Override
    public boolean existVertice(Vertice vertice) {
        for (Map.Entry<Vertice, Integer> verticeIntegerEntry : VertToInt.entrySet()) {
            if (verticeIntegerEntry.getKey().equals(vertice)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void adicionarVertice(Vertice vertice) {

        if (!existVertice(vertice)) {
            mapeiaVertice(vertice);
        }

    }

    @Override
    public void adicionarAresta(Vertice verticeOrigem, Vertice verticeDestino) {
        adicionarVertice(verticeOrigem);
        adicionarVertice(verticeDestino);
        adicionaAdjacencia(verticeOrigem, verticeDestino);
    }

    private void adicionaAdjacencia(Vertice verticeOrigem, Vertice verticeDestino) {
        if (existVertice(verticeOrigem) && existVertice(verticeDestino)) {
            this._matrizAdj[this.VertToInt.get(verticeOrigem)][this.VertToInt.get(verticeDestino)] = 1;
        }
    }
}
