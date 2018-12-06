package agencia;

import java.util.ArrayList;

public class Pacote {
    private String nome, dataInicio, dataFim;
    private double preco;
    private Agencia agencia;
    private ArrayList <Cidade> cidades = new ArrayList<Cidade>();
    private ArrayList <Atracao> atracoes = new ArrayList<Atracao>();


    public Pacote(String nome, String datai, String dataf, double preco, Agencia agencia) {
        this.nome = nome;
        this.dataInicio = datai;
        this.dataFim = dataf;
        this.preco = preco;
        this.agencia = agencia;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataFim(String dFim) {
        this.dataFim = dFim;
    }

    public void setCidade(Cidade c) {
        this.cidades.add(c);
    }

    public void setAtracao(Atracao a) {
        this.atracoes.add(a);
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public String getName() {
        return this.nome;
    }


    public String getDataIni() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public double getPreco() {
        return preco;
    }

    public ArrayList<Cidade> getCidades() {
        return this.cidades;
    }

    public ArrayList<Atracao> getAtracoes() {
        return this.atracoes;
    }

    @Override
    public String toString() {
        return "Pacote: " + this.nome + ", Período válido: " + this.dataInicio + " até " +
                this.dataFim + ", Preço: R$ " + this.preco + ", Cidades: " + this.cidades +
                ", Atrações: " + this.atracoes;
    }



}
