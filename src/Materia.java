public class Materia{

    //--------- PROPIEDADES ---------------------------------------
    String nombre;
    int capacidad;
    Profesor profesor;


    //----------- CONSTRUCTOR -------------------------------------





    //-------------------- GETTERS Y SETTERS ----------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
