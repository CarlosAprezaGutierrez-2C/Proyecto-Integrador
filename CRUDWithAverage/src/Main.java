import java.util.Scanner;

public class Main {

    static Persona[] persona=new Persona[25];
    static PersonaService metodoPersona=new PersonaService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        double pedirOpcion=mostrarrMsj(sc,"Introduce una opcion : 0-salir  1-Alta Alumno, 2-Buscar por Id (solo activos)" +
                ", 3-Actualizar promedio por Id, 4-baja logica por Id, 5- Listar activos 6- Reportes de calificaciones   ");
    }



    public static  void leerOpciones (Scanner input,int opcion){

        switch (opcion){
            case 0: input.close(); break;
            case 1: metodoPersona.altaPersona(input,persona); break;
            case 2: metodoPersona.buscarPersona(input,persona); break;
            case 3: metodoPersona.actualizarPromedio(persona,input); break;
            case 4: metodoPersona.bajaLogica(input,persona); break;
            case 5: metodoPersona.listarPersonas(persona); break;
            case 6: metodoPersona.reportes(persona); break;
            default:
                System.out.println("Opcion incorrecta");

        }
    }

    public static double mostrarrMsj(Scanner input,String msj){
        int opcion;
        do{

            System.out.println(msj);
            opcion=input.nextInt();
            leerOpciones(input,opcion);

        } while (opcion!=0);
        return opcion;
    }





}
