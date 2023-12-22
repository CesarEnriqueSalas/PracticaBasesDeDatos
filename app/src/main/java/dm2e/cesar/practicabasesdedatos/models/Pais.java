package dm2e.cesar.practicabasesdedatos.models;

public class Pais {

    private int paisId;
    private String pais;

    public Pais(int paisId, String pais) {
        this.paisId = paisId;
        this.pais = pais;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
