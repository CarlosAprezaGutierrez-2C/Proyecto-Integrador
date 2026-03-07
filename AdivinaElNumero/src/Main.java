import java.util.Random;
import java.util.Scanner;

public class Main {
    static int numeroSecreto = 0;
    static int contadorDatosNoNumerico = 0;
    static int contadorFueraDeRango = 0;
    static int contadorIntentos = 0;
    static int limiteDeIntentos = 7;
    static boolean gano = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();
        numeroSecreto = aleatorio.nextInt(100) + 1;

        System.out.println("Bienvenidos al programa adivina un numero del 1 al 100");

        while (contadorIntentos < limiteDeIntentos && !gano) {
            System.out.println("Intento " + (contadorIntentos + 1) + " de: " + limiteDeIntentos);

            int recibirNumero = pedirNumero(1, 100, sc);
            contadorIntentos++;

            compararNumeros(recibirNumero);
        }

        if (!gano) {
            System.out.println("Has perdido el numero secreto era: " + numeroSecreto);
        }

        System.out.println("\n--Estadisticas--");
        System.out.println("Intentos usados: " + contadorIntentos);
        System.out.println("Fuera de rango: " + contadorFueraDeRango);
        System.out.println("No numerico: " + contadorDatosNoNumerico);

        sc.close();
    }

    public static int pedirNumero(int numMin, int numMax, Scanner sc) {
        while (true) {
            System.out.println("Ingresa un numero del " + numMin + " al " + numMax + ": ");

            if (!sc.hasNextInt()) {
                System.out.println("Ingresa un numero valido (entero).");
                contadorDatosNoNumerico++;
                sc.next(); // consume lo invalido
                continue;
            }

            int numero = sc.nextInt();

            if (numero < numMin || numero > numMax) {
                System.out.println("Error: el numero debe estar entre " + numMin + " y " + numMax);
                contadorFueraDeRango++;
                continue;
            }

            return numero;
        }
    }

    public static void compararNumeros(int numero) {
        if (numero == numeroSecreto) {
            System.out.println("Felicidades ganaste en el intento: " + contadorIntentos);
            gano = true;
        } else if (numeroSecreto > numero) {
            System.out.println("El numero secreto es mayor al numero ingresado");
        } else {
            System.out.println("El numero secreto es menor al numero ingresado");
        }
    }
}
