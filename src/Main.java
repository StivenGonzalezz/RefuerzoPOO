import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
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

        switch (opc){
            case 1:
                String clave = JOptionPane.showInputDialog(null, "ingrese la contraseña");
                String claveAdmin = "0000";
                String mensaje;

                //
                //mensaje = (clave==claveAdmin)?menuAdministrativo(): "Acceso Denegado";
                //JOptionPane.showMessageDialog(null,mensaje);

                if(Objects.equals(clave, claveAdmin)){
                    JOptionPane.showMessageDialog(null, "Acceso concedido");
                    menuAdministrativo();
                }else JOptionPane.showMessageDialog(null, "Clave incorrecta");
                break;

            case 2:
                menuEstudiante();
                break;

            default:JOptionPane.showMessageDialog(null, "Saliendo");
        }

    }while (opc != 3);



}

    private static void menuEstudiante() {
        String id = JOptionPane.showInputDialog(null, "Ingrese su numero de indentificacion");
    }

    private static void menuAdministrativo() {
        int opcAdmin;
        do {
            opcAdmin = Integer.parseInt(JOptionPane.showInputDialog(
                "------------------------------------------------------\n"+
                "    BIENVENIDO AL MENU ADMINISTRATIVO   \n\n\n"+
                "1. Registrar estudiante\n"+
                "2. Registrar Profesor\n"+
                "3. Crear Curso\n"+
                "4. Vincular Profesor a Curso\n"+
                "5. Agregar Notas\n"+
                "6. Agregar Estudiante a Curso\n"+
                "7. Eliminar Estudiante a Curso\n"+
                "8. Salir\n\n"+
                "------------------------------------------------------"));
        }while (opcAdmin != 8);
    }
}