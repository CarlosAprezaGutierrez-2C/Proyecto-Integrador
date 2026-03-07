import java.util.Scanner;

public class inputValidation {

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("El valor está fuera del rango");
                }
            } else {
                System.out.println("Por favor ingresa un número válido");
                sc.nextLine();
            }
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;

        while (true) {
            System.out.println(msg);


            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine();

                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("El valor está fuera del rango");
                }
            } else {
                System.out.println("Por favor ingresa un número válido");
                sc.nextLine();
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);

            if (sc.hasNextBoolean()) {
                boolean valor = sc.nextBoolean();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Por favor ingresa true o false");
                sc.nextLine();
            }
        }
    }
}
