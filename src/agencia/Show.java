package agencia;

public class Show extends Atracao {
    private String bandas;

    public Show(String name, String data, String horas, String text, Endereco endereco) {
        super(name, data, horas, endereco);
        this.bandas = text;
    }

    public String getBandas() {
        return this.bandas;
    }

}
