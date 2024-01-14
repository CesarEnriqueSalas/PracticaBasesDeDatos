package dm2e.cesar.practicabasesdedatos.models;

public class CodeIsoPais {

    private int codeID;

    private String codeIsoPais;

    private int paisId;

    public CodeIsoPais(int codeID, String codeIsoPais, int paisId) {
        this.codeID = codeID;
        this.codeIsoPais = codeIsoPais;
        this.paisId = paisId;
    }

    public int getCodeID() {
        return codeID;
    }

    public void setCodeID(int codeID) {
        this.codeID = codeID;
    }

    public String getCodeIsoPais() {
        return codeIsoPais;
    }

    public void setCodeIsoPais(String codeIsoPais) {
        this.codeIsoPais = codeIsoPais;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }
}
