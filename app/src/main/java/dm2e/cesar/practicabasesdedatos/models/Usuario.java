package dm2e.cesar.practicabasesdedatos.models;

public class Usuario {

    private int usuarioId;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String email;
    private String codigoIsoPais;

    public Usuario(int usuarioId, String nombre, String apellido, String nombreUsuario, String email, String codigoIsoPais) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.codigoIsoPais = codigoIsoPais;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoIsoPais() {
        return codigoIsoPais;
    }

    public void setCodigoIsoPais(String codigoIsoPais) {
        this.codigoIsoPais = codigoIsoPais;
    }
}
