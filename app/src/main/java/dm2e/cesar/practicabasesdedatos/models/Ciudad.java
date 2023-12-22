package dm2e.cesar.practicabasesdedatos.models;

public class Ciudad {

    private int ciudadId;
    private String ciudad;
    private int paisId;

    public Ciudad(int ciudadId, String ciudad, int paisId) {
        this.ciudadId = ciudadId;
        this.ciudad = ciudad;
        this.paisId = paisId;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }
}
