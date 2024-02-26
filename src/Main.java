import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    static ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    static ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    static ArrayList<Materia> materias = new ArrayList<Materia>();

    public static void main(String[] args) {

        estudiantes.add(new Estudiante("stiven","gonzalez",1,20));
        estudiantes.add(new Estudiante("mauricio","quintero",2,32));
        profesores.add(new Profesor("carlos","marin",10,new Materia("castellano",20, true, true)));
        profesores.add(new Profesor("pedro","londoño",11,null));
        materias.add(new Materia("ingles", 5, true, false));
        menu();

    }
public static void menu(){

    int opc; 
    do{
        opc = Integer.parseInt(input(
        "------------------------------------------------------\n"+
        "    BIENVENIDO AL MENU ACADEMICO    \n\n\n"+
        "1. Ingresar al menu administrativo\n"+
        "2. Revisar mis notas\n"+
        "3. Salir\n\n"+
        "------------------------------------------------------")
        );
        System.out.println(opc);

        // DEPENDIENDO DE LA OPCION ELEGIDA ANTERIORMENTE EN EL MENU GENERAL SE MUESTRA EL MENU ADMIN O MENU ESTUDIANTE
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

            case 3:JOptionPane.showMessageDialog(null, "Cerrando programa");
                break;
            default:JOptionPane.showMessageDialog(null, "Digitacion invalida");
        }

    }while (opc != 3);

}

    private static void menuEstudiante() {
        String id = JOptionPane.showInputDialog(null, "Ingrese su numero de indentificacion");
    }

    //     FUCION QUE MUESTRA EL MENU ADMINISTRATIVO  Y DA OPCIONES POSIBLES
    private static void menuAdministrativo() {
        int opcAdmin;
        do {
            opcAdmin = Integer.parseInt(input(
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
                    registrarEstudiante();
                    break;

                case 2:
                    registrarProfesor();
                    break;

                case 3:
                    crearCurso();
                    break;

                case 4:
                    vincularProfesorAMateria();
                    break;

                case 5:
                    agregarNotas();
                    break;

                case 6:
                    Materia.CerrarNotas();
                    break;

                case 7:
                    Materia.AgregarEstudianteAlCurso();
                    break;

                case 8:
                    Materia.EliminarEstudianteDelCurso();
                    break;

                case 9:JOptionPane.showMessageDialog(null, "Volviendo al menu principal . . .");

            }
        }while (opcAdmin != 9);

    }

    //-------- OPCIONES DEL MENU ADMINISTRATIVO ------

    //Método para registrar un nuevo estudiante.
    private static void registrarEstudiante() {
        String nombres = input("ingrese el nombre del estudiante");
        String apellidos = input("ingrese los apellidos del estudiante");
        int id = Integer.parseInt(input("ingrese el id del estudiante"));
        int edad= Integer.parseInt(input("Ingrese la edad del estudiante"));
        estudiantes.add(new Estudiante(nombres, apellidos, id, edad));
    }
    private static void registrarProfesor() {
        String nombres = input("ingrese el nombre del profesor");
        String apellidos = input("ingrese los apellidos del profesor");
        int id = Integer.parseInt(input("ingrese el id del profesor"));
        String materiaProfesor = input("ingrese el nombre de la materia al cual desea vincular el profesor\n" +
                "(en caso de no querer vinularlo a ninguna deje el espacio en blanco)");

        Materia materia = buscarMateria(materiaProfesor);
        if (materia != null) profesores.add(new Profesor(nombres, apellidos, id, materia));
        else {
            output("la materia no ha sido encontrada, no se asignara materia al profesor");
            profesores.add(new Profesor(nombres, apellidos, id, null));
        }
    }
    private static void crearCurso() {
        String nombreMateria = input( "Ingrese el nombre de la materia");
        int capacidadMateria = Integer.parseInt(input( "ingrese el cupo maximo de la materia"));
        int idProfesor = Integer.parseInt((input( "ingrese la identificacion del docente si lo hay")));
        Profesor profesorACargo = buscarProfesor(idProfesor);
        boolean cursoAsignado = false;
        if (profesorACargo != null & (profesorACargo != null ? profesorACargo.getMateria() : null) ==null)cursoAsignado = true;

        Materia m = new Materia(nombreMateria,capacidadMateria,true, cursoAsignado);
        materias.add(m);

        if (cursoAsignado){
            output( "Curso creado con profesor a cargo");
            profesorACargo.setMateria(m);
        } else {
            input("           Curso creado sin profesor a cargo\n\n" +
                    "esto es debido a que:\n"+
                    "   *El profesor decretado ya tiene un curso asignado\n" +
                    "   *El id proporcioado no esta registrado");
        }
    }
    private static void vincularProfesorAMateria() {
        String materiaABuscar = input("ingrese le nombre de la maeria al cual desea asignar un docente");
        Materia materia = buscarMateria(materiaABuscar);

        int profesorABuscar = Integer.parseInt(input( "Ingrese el id del profesor al cual desea asignar la materia"));
        Profesor profesor = buscarProfesor(profesorABuscar);

        if (materia != null && !materia.isAsignado() & profesor.getMateria()==null ){
            profesor.setMateria(materia);
            output("profesor vinculado correctamente");
            profesor.info();
        }else output("Alguno de los datos bridados no ha sido digitado correctamente, verifique su informacion");

    }
    private static void agregarNotas() {
        int id = Integer.parseInt(input("ingrese el id del profesor que desea ingresar notas"));
        Profesor profesor = buscarProfesor(id);
        if (profesor!=null) & profesor.getMateria() != null{

        }


    }

    //---------METODOS PARA BUSCAR -------------------
    private static Profesor buscarProfesor(int id) {
        Profesor profesorEncontrado = null;
        for (Profesor profesor : profesores){
            if (profesor.getId() == id){profesorEncontrado = profesor;}
        }
        return profesorEncontrado;
    }
    public static Estudiante buscarEstudiante(int id){
        Estudiante estudianteEncontrado = null;
        for (Estudiante estudiante : estudiantes){
            if (estudiante.getId() == id){estudianteEncontrado = estudiante;}
        }
        return estudianteEncontrado;
    }
    public static Materia buscarMateria(String nombre){
        Materia materiaEncontrada = null;
        for (Materia materia : materias) {
            if (materia.getNombre().equals(nombre)) materiaEncontrada = materia;
        }
        return  materiaEncontrada;
    }

    //-----------METODOS JOPTION PARA ACOSTAR EL CODIGO--------
    public static String input(String mensaje){
        return JOptionPane.showInputDialog(null, mensaje);
    }
    public static void output(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

}