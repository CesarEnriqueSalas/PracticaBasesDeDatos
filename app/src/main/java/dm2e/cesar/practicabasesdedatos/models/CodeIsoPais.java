package dm2e.cesar.practicabasesdedatos.models;

public class CodeIsoPais {

    private int codeId;

    private String codigoIsoPais;
    private int paisId;

    public CodeIsoPais(int codeId, String codigoIsoPais, int paisId) {
        this.codigoIsoPais = codigoIsoPais;
        this.paisId = paisId;
        this.codeId = codeId;
    }

    public int getCodeId() { return codeId;}
    public String getCodigoIsoPais() {
        return codigoIsoPais;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public void setCodigoIsoPais(String codigoIsoPais) {
        this.codigoIsoPais = codigoIsoPais;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }
}
