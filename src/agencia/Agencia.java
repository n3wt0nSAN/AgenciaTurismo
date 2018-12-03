package agencia;

import java.util.ArrayList;

public class Agencia {
    private String nomeFantasia, cnpj;
    private Endereco endereco;
    private ArrayList <Contato> contatos;
    private ArrayList <Pacote> pacotes;

    public Agencia (String nome, String cnpj, Endereco endereco) {
        this.nomeFantasia = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void setContato(Contato c) {
        this.contatos.add(c);
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setPacote(Pacote p) {
        this.pacotes.add(p);
    }

    public ArrayList<Pacote> getPacote() {
        return pacotes;
    }

    @Override
    public String toString() {
        return this.nomeFantasia + ", CNPJ: " + this.cnpj + ", " +
               this.endereco.toString();
    }

    public String getName() {
        return this.nomeFantasia;
    }
}
