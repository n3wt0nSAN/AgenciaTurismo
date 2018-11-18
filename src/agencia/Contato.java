package agencia;

public class Contato {
    private String numTel, email;

    public Contato(String numTel, String email) {
        this.numTel = numTel;
        this.email = email;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getEmail() {
        return email;
    }
}
