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

    // metodo toString()
    @Override
    public String toString() {
        return "Rua: " + this.rua + ", Número: " + this.numero + ", agencia.Cidade: " + this.cidade.nome +
                ", Estado: " + this.cidade.estado + ", CEP: " + this.cep + ", Pais: " + this.cidade.pais;
    }
}
