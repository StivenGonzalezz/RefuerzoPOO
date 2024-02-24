import javax.swing.*;
import java.util.ArrayList;

public class Estudiante extends Persona{

    int edad;
    int[] notas = new int[5];
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

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
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

}
