import java.util.Scanner;

public class Main {
    public static double variableA, variableB;
    public static String opcion;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos
        pedirNumeros(sc);
        pedirOpciones(sc);

        // Resolver operación
        double resultado = switchOpciones(sc);

        // Mostrar resultados
        System.out.println("La opcion que eligiste fue: " + opcion);
        System.out.println("El resultado de la operacion es: " + resultado);
        System.out.println("Los numeros ingresados fueron: a = " + variableA + " y b = " + variableB);

        sc.close();
    }

    // Metodo para pedir los numeros
    public static void pedirNumeros(Scanner leer) {
        System.out.println("Ingrese el numero a:");
        variableA = leer.nextDouble();

        System.out.println("Ingrese el numero b:");
        variableB = leer.nextDouble();

        leer.nextLine();
    }

    // Metodo para que el usuario pueda pedir opciones
    public static String pedirOpciones(Scanner leer) {
        System.out.println("Ingresa una opcion");
        System.out.println("Sumar");
        System.out.println("Restar");
        System.out.println("Multiplicar");
        System.out.println("Dividir");
        System.out.println("Salir");

        opcion = leer.nextLine().trim().toLowerCase();
        return opcion;
    }

    // Metodos para las operaciones
    public static double sumar() {
        return variableA + variableB;
    }

    public static double restar() {
        return variableA - variableB;
    }

    public static double multiplicar() {
        return variableA * variableB;
    }

    public static double dividir() {
        if (variableB == 0.0) {
            System.out.println("No se puede dividir por cero");
            return 0;
        }
        return variableA/ variableB;
    }

    // Metodo para el switch
    public static double switchOpciones(Scanner leer) {
        switch (opcion) {
            case "sumar":
                return sumar();

            case "restar":
                return restar();

            case "multiplicar":
                return multiplicar();

            case "dividir":
                return dividir();

            case "salir":
                System.out.println("Gracias por usar este programa");
                return 0;

            default:
                System.out.println("Opcion no valida");
                return 0;
        }
    }
}


