import javax.swing.*;
import java.util.ArrayList;

public class Estudiante extends Persona{

    int edad;
    double[] notas;
    ArrayList<Materia> materiasRegistradas = new ArrayList<Materia>();

    public Estudiante(String nombres, String apellidos, int id, int edad){
        super(nombres, apellidos, id);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public ArrayList<Materia> getMateriasRegistradas() {
        return materiasRegistradas;
    }

    public void setMateriasRegistradas(ArrayList<Materia> materiasRegistradas) {
        this.materiasRegistradas = materiasRegistradas;
    }

    public Object info() {

        JOptionPane.showMessageDialog(null, "   INFORMACION   \n" +
                "Nombres: " + nombres+"\n"+
                "Apellidos: " + apellidos+"\n"+
                "Identificacion: " + id+"\n"+
                "Edad: " +edad+"\n"
        );
        return null;
    }

    // Método para verificar si el estudiante tiene calificación en todas las notas
    public boolean tieneCalificacion() {
        if (notas == null) {
            return false;
        }

        for (double calificacion : notas) {
            if (calificacion == 0.0) {
                return false;
            }
        }

        return true;
    }

    // Método para asignar una calificación a un estudiante
    public void asignarCalificacion(double calificacion) {
        if (notas == null) {
            notas = new double[4];
        }
        // Verifica que la calificación esté en el rango de 0.0 a 5.0
        if (calificacion >= 0.0 && calificacion <= 5.0) {
            for (int i = 0; i < notas.length; i++) {
                if (notas[i] == 0.0) {
                    notas[i] = calificacion;
                    JOptionPane.showMessageDialog(null, "Calificación asignada: " + calificacion);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "El estudiante ya tiene todas las calificaciones asignadas.");
        } else {
            JOptionPane.showMessageDialog(null, "La calificación debe estar en el rango de 0.0 a 5.0.");
        }
    }

}
