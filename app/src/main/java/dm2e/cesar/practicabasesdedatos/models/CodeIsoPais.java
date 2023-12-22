package dm2e.cesar.practicabasesdedatos.models;

public class CodeIsoPais {

    private String codigoIsoPais;
    private int paisId;

    public CodeIsoPais(String codigoIsoPais, int paisId) {
        this.codigoIsoPais = codigoIsoPais;
        this.paisId = paisId;
    }

    public String getCodigoIsoPais() {
        return codigoIsoPais;
    }

    public int getPaisId() {
        return paisId;
    }

}
