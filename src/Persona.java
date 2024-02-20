public class Persona {

    String nombres;
    String apellidos;
    int id;

    public Persona(){}

    public Persona(String nombres, String apellidos, int id) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
