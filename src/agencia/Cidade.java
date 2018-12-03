package agencia;

import java.util.ArrayList;

public class Cidade {
    private String nome, estado, pais;
    //

    public Cidade(String name, String state, String country) {
        this.nome = name;
        this.estado = state;
        this.pais = country;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return this.nome + ", " + this.estado + ", " + this.pais;
    }

}
