public class UsuariosDeuda {

    UsuariosDeuda(){
        nombre="";
        deuda = 0;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda += deuda;
    }


    private String nombre;
    private int deuda;
}
