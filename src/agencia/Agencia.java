package agencia;

import java.util.ArrayList;

public class Agencia {
    private String nomeFantasia, cnpj;
    private Endereco endereco;
    private ArrayList <Pacote> pacotes;

    public Agencia (String nome, String cnpj, Endereco endereco) {
        this.nomeFantasia = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void setPacote(Pacote p) {
        this.pacotes.add(p);
    }

    public String getNome() {
        return this.nomeFantasia;
    }

    public ArrayList<Pacote> getPacotes() {
        return pacotes;
    }

    @Override
    public String toString() {
        return this.nomeFantasia + ", CNPJ: " + this.cnpj + ", " +
               this.endereco.toString();
    }
}
