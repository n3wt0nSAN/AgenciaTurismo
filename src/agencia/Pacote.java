package agencia;

import agencia.Cidade;

import java.util.ArrayList;

public abstract class Pacote {
    private String nome, dataInicio, dataFim;
    private ArrayList <Cidade> cidades;
    private double preco;

    public Pacote(String nome, String di, String df, double p) {
        this.nome = nome;
        this.dataInicio = di;
        this.dataFim = df;
        this.preco = p;
    }

    public void setdFim(String dFim) {
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
