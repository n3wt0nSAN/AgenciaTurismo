package agencia;

import agencia.Cidade;

import java.util.ArrayList;

public abstract class Pacote {
    private String nome, dataInicio, dataFim;
    private ArrayList <Cidade> cidades;
    private double preco;

    public Pacote(String nome, String datai, String dataf, double preco) {
        this.nome = nome;
        this.dataInicio = datai;
        this.dataFim = dataf;
        this.preco = preco;
    }

    public void setDataFim(String dFim) {
        this.dataFim = dFim;
    }

    public void setCidade(Cidade c) {
        this.cidades.add(c);
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    @Override
    public String toString() {
        return "agencia.Pacote: " + this.nome + ", Datas: " + this.dataInicio + " até " +
                this.dataFim + ", Preço: " + this.preco;
    }
}
