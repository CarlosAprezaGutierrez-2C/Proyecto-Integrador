
import java.util.Scanner;

public class Main {

    static int opcion;
    static int contador = 0;
    static int contadorCelciusAFarenheit = 0;
    static int contadorFarenheitACelcius = 0;
    static int contadorKilometrosAMillas = 0;
    static int contadorMillasAKilometros = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            pedirNumeroalUsuario(input);
            switchOpciones(input);
        } while (opcion != 5);

        System.out.println("\n===== ESTADISTICAS =====");
        System.out.println("Total de operaciones: " + contador);
        System.out.println("Celsius a Fahrenheit: " + contadorCelciusAFarenheit);
        System.out.println("Fahrenheit a Celsius: " + contadorFarenheitACelcius);
        System.out.println("Kilometros a Millas: " + contadorKilometrosAMillas);
        System.out.println("Millas a Kilometros: " + contadorMillasAKilometros);
    }

    public static void pedirNumeroalUsuario(Scanner input) {
        while (true) {
            try {
                System.out.println("\nBienvenido al menu de opciones :");
                System.out.println("1. Calcular Celsius a Fahrenheit");
                System.out.println("2. Calcular Fahrenheit a Celsius");
                System.out.println("3. Calcular Kilometros a Millas");
                System.out.println("4. Calcular Millas a Kilometros");
                System.out.println("5. Salir");
                System.out.print("Elige una opcion : ");

                opcion = input.nextInt();
                input.nextLine();
                break;

            } catch (Exception e) {
                System.out.println("Elige una opcion valida.");
                input.nextLine();
            }
        }
    }

    public static double switchOpciones(Scanner input) {
        switch (opcion) {
            case 1:
                return calcularCelciusAFarenheit(input);
            case 2:
                return calcularFarenheitACelcius(input);
            case 3:
                return calcularKilometrosAMillas(input);
            case 4:
                return calcularMillasAKilometros(input);
            case 5:
                System.out.println("Gracias por usar el programa");
                System.exit(0);
            default:
                System.out.println("Opcion invalida");
                return 0;
        }
    }

    public static double calcularCelciusAFarenheit(Scanner input) {
        while (true) {
            try {
                System.out.print("Ingresa los grados Celsius: ");
                double celcius = input.nextDouble();
                input.nextLine();

                double resultado = (celcius * 1.8) + 32;

                contador++;
                contadorCelciusAFarenheit++;

                System.out.printf("El resultado son %.2f °F (Fahrenheit)\n", resultado);
                return resultado;

            } catch (Exception e) {
                System.out.println("Ingresa un numero valido.");
                input.nextLine();
            }
        }
    }

    public static double calcularFarenheitACelcius(Scanner input) {
        while (true) {
            try {
                System.out.print("Ingresa los grados Fahrenheit: ");
                double farenheit = input.nextDouble();
                input.nextLine();

                double resultado = (farenheit - 32) / 1.8;

                contador++;
                contadorFarenheitACelcius++;

                System.out.printf("El resultado son %.2f °C (Celsius)\n", resultado);
                return resultado;

            } catch (Exception e) {
                System.out.println("Ingresa un numero valido.");
                input.nextLine();
            }
        }
    }

    public static double calcularKilometrosAMillas(Scanner input) {
        while (true) {
            try {
                System.out.print("Ingresa los kilometros: ");
                double km = input.nextDouble();
                input.nextLine();

                double resultado = km * 0.621371;

                contador++;
                contadorKilometrosAMillas++;

                System.out.printf("El resultado son %.2f millas\n", resultado);
                return resultado;

            } catch (Exception e) {
                System.out.println("Ingresa un numero valido.");
                input.nextLine();
            }
        }
    }

    public static double calcularMillasAKilometros(Scanner input) {
        while (true) {
            try {
                System.out.print("Ingresa las millas: ");
                double millas = input.nextDouble();
                input.nextLine();

                double resultado = millas * 1.60934;

                contador++;
                contadorMillasAKilometros++;

                System.out.printf("El resultado son %.2f kilometros\n", resultado);
                return resultado;

            } catch (Exception e) {
                System.out.println("Ingresa un numero valido.");
                input.nextLine();
            }
        }
    }
}


