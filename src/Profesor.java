import javax.swing.*;

public class Profesor extends Persona{

    Materia materia;

    public Profesor(String nombres, String apellidos, int id, Materia materia){
        super(nombres, apellidos, id);
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


    public void info() {
        JOptionPane.showMessageDialog(null, "   INFORMACION   \n" +
                "Nombres: " + nombres+"\n"+
                "Apellidos: " + apellidos+"\n"+
                "Identificacion: " + id+"\n"+
                "Materia: " +materia.getNombre()+"\n"
                );
        }
}
