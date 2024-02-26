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

    //Método para agregar un estudiante al curso
    public void AgregarEstudianteAlCurso(Estudiante estudiante) {
        if (estudiantesRegistrados == null) {
            estudiantesRegistrados = new ArrayList<>();
        }
        // Verifica si la materia está abierta y la capacidad no ha sido alcanzada
        if (estado && estudiantesRegistrados.size() < capacidad) {
            estudiantesRegistrados.add(estudiante);
            JOptionPane.showMessageDialog(null, "Estudiante agregado a la materia: " + estudiante.getNombres());
        } else {
            JOptionPane.showMessageDialog(null, "No se puede agregar mas estudiantes a la materia.");
        }
    }

     // Método para eliminar un estudiante del curso
     public void EliminarEstudianteDelCurso(Estudiante estudiante) {
        if (estudiantesRegistrados != null && estudiantesRegistrados.contains(estudiante)) {
            estudiantesRegistrados.remove(estudiante);
            JOptionPane.showMessageDialog(null, "Estudiante eliminado de la materia: " + estudiante.getNombres());
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante no esta registrado en esta materia.");
        }
    }

    //Método para cerrar las notas del curso
    public void CerrarNotas() {
        if (estudiantesRegistrados != null && !estudiantesRegistrados.isEmpty()) {
            // Verificar que todas las calificaciones estén ingresadas (si no, asignar 0.0)
            for (Estudiante estudiante : estudiantesRegistrados) {
                if (!estudiante.tieneCalificacion()) {
                    estudiante.asignarCalificacion(0.0);
                }
            }

            estado = false;
            System.out.println("Notas del curso cerradas correctamente.");
        } else {
            System.out.println("No hay estudiantes registrados en esta materia.");
        }
    }
}
