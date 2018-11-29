package agencia;

public class Museu extends Atracao {
    protected String historia;

    public Museu(String nome, String data, String horario, String historia, Endereco endereco) {
        super(nome, data, horario, endereco);
        this.historia = historia;
    }

    public String getHistoria() {
        return historia;
    }
}

