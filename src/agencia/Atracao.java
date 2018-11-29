package agencia;

public class Atracao {
    protected String nome, data, horario;
    protected Endereco endereco;

    public Atracao(String nome, String data, String horario, Endereco endereco) {
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }
}
