import javax.swing.*;
import java.util.ArrayList;

public class Materia{

    //--------- PROPIEDADES ---------------------------------------
    String nombre;
    int capacidad;
    boolean estado;
    boolean asignado;
    ArrayList<Estudiante> estudiantesRegistrados = new ArrayList<Estudiante>();

    //----------- CONSTRUCTOR -------------------------------------

    public Materia(String nombre, int capacidad, boolean estado, boolean asignado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.asignado = asignado;
    }

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
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean isAsignado() {
        return asignado;
    }
    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    public ArrayList<Estudiante> getEstudiantesRegistrados() {
        return estudiantesRegistrados;
    }
    public void setEstudiantesRegistrados(ArrayList<Estudiante> estudiantesRegistrados) {
        this.estudiantesRegistrados = estudiantesRegistrados;
    }

    public void info(){
        JOptionPane.showMessageDialog(null, "   INFORMACION   \n" +
                "Nombre: " + nombre +"\n"+
                "Cupos: " + capacidad+"\n"+
                "Estado?: " + estado+"\n"+
                "Asignado?: " +asignado+"\n"
        );
    }
}
