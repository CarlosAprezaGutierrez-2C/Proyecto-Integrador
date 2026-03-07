import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        PersonaService service = new PersonaService();
        int opcion = -1;

        do {
            System.out.println("Menu");
            System.out.println("1.- Alta 2.- Buscar por ID 3.- Baja logica 4.- Listar activas 5.- Actualizar nombre 0.- Salir");
            System.out.print("elige la opcion que deseas realizar  ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1: service.alta(sc, personas);
                        break;
                    case 2: service.buscar(sc, personas);
                        break;
                    case 3: service.bajaLogica(sc, personas);
                        break;
                    case 4: service.listarActivas(personas);
                        break;
                    case 5: service.actualizarNombre(sc, personas);
                        break;
                    case 0: System.out.println("Adios.");
                        break;


                    default: System.out.println("Opcion invalida.");
                }
            } else {
                System.out.println("Ingresa un numero valido");
                sc.next();
            }
        } while (opcion != 0);
    }
}