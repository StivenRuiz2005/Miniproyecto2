public class Libros {

    Libros() {
        estado = true;
        nombre= "";
        nom_usuario="";
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {this.estado = estado;}

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    private boolean estado;
    private String nombre;
    private String nom_usuario;
};


