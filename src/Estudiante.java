import javax.swing.*;

public class Estudiante extends Persona{

    int edad;

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

    public void info() {
        JOptionPane.showMessageDialog(null, "   INFORMACION   \n" +
                "Nombres: " + nombres+"\n"+
                "Apellidos: " + apellidos+"\n"+
                "Identificacion: " + id+"\n"+
                "Edad: " +edad+"\n"
        );
    }

}
