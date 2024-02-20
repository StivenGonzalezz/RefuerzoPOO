import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        ArrayList<Materia> materias = new ArrayList<Materia>();
        menu();
}

public static void menu(){

    int opc; 
    do{
        opc = Integer.parseInt(JOptionPane.showInputDialog(
        "------------------------------------------------------\n"+
        "    BIENVENIDO AL MENU ACADEMICO    \n\n\n"+
        "1. Ingresar al menu administrativo\n"+
        "2. Revisar mis notas\n"+
        "3. Salir\n\n"+
        "------------------------------------------------------")
        );


        // DEPENDIENDO DE LA OPCION ELEGIDA ANTERIORMENTE EN EL MENU GENERAL SE MUESRA EL MENU ADMIN O MENU ESTUDIANTE
        switch (opc){
            case 1:
                String clave = JOptionPane.showInputDialog(null, "ingrese la contraseña");
                String claveAdmin = "0000";
                String mensaje;

                //
                //clave==claveAdmin?menuAdministrativo(): mensajeError();
                //JOptionPane.showMessageDialog(null,mensaje);

                // VALIDA QUE LA CLAVE INGRESADA SEA LA CORRECTA Y EN CASO DE SER ASI MUESTRA EL MENU ADMIN
                if(Objects.equals(clave, claveAdmin)){
                    JOptionPane.showMessageDialog(null, "Acceso concedido");
                    menuAdministrativo();
                }else JOptionPane.showMessageDialog(null, "Clave incorrecta");
                break;

            case 2:
                menuEstudiante();
                break;

            default:JOptionPane.showMessageDialog(null, "Cerrando programa");
        }

    }while (opc != 3);

}

    //FUNCION QUE SE USARA EN CASO DE GENERAL ALGUN ERROR
    private static void mensajeError() {JOptionPane.showMessageDialog(null,"error");
    }

    private static void menuEstudiante() {
        String id = JOptionPane.showInputDialog(null, "Ingrese su numero de indentificacion");
    }

    //     FUCION QUE MUESTRA EL MENU ADMINISTRATIVO  Y DA OPCIONES POSIBLES
    private static void menuAdministrativo() {
        int opcAdmin;
        do {
            opcAdmin = Integer.parseInt(JOptionPane.showInputDialog(
                "------------------------------------------------------\n"+
                " BIENVENIDO AL MENU ADMINISTRATIVO   \n\n\n"+
                "1. Registrar estudiante\n"+
                "2. Registrar Profesor\n"+
                "3. Crear Curso\n"+
                "4. Vincular Profesor a Curso\n"+
                "5. Agregar Notas\n"+
                "6. Cerrar notas de curso\n"+
                "7. Agregar Estudiante a Curso\n"+
                "8. Eliminar Estudiante a Curso\n"+
                "9. Salir\n\n"+
                "------------------------------------------------------"));

            switch (opcAdmin){
                case 1:

                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:JOptionPane.showMessageDialog(null, "Volviendo al menu principal . . .");

            }
        }while (opcAdmin != 9);

        //return opcAdmin;
    }
}