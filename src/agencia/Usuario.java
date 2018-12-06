package agencia;

import agencia.Contato;
import agencia.Pacote;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private Contato contato;
    private ArrayList <Pacote> pacote;

    public Usuario (String nome, Contato contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public void setPacote(Pacote p) {
        this.pacote.add(p);
    }

    public ArrayList<Pacote> getPacotes() {
        return pacote;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "Contatos: " + this.contato.getEmail() + ", " +
                this.contato.getNumTel();
    }
}
