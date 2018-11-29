package agencia;

public class Praia extends Atracao {
    private String precoMedios;

    public Praia(String name, String data, String horas, String text, Endereco endereco) {
       super(name, data, horas,endereco);
       this.precoMedios = text;
    }
}
