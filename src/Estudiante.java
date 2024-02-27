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

    public void getNotas() {
        JOptionPane.showMessageDialog(null,"    NOTAS\n\n" +
                "Nota 1: "+ notas[0]+"\n"+
                "Nota 2: "+ notas[1]+"\n"+
                "Nota 3: "+ notas[2]+"\n"+
                "Nota 4: "+ notas[3]);
                getDefinitiva();
    }

    public void getDefinitiva(){
        double def = (notas[0] + notas[1] + notas[2] + notas[3]);
        JOptionPane.showMessageDialog (null,"nota definitiva: "+ def);
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

}
