package agencia;

import agencia.Cidade;

public class Endereco {
    private String rua, bairro, cep;
    private Integer numero;
    private Cidade cidade;

    public Endereco (String rua, Integer num, String bairro, String cep, Cidade cidade) {
        this.rua = rua;
        this.numero = num;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    // metodo toString()
    @Override
    public String toString() {
        return "ENDEREÇO: " + this.rua + ", NÚMERO: " + this.numero + ", BAIRRO: " + this.bairro + ", CEP: " + this.cep +
                ", " + this.cidade.toString();
    }


}
