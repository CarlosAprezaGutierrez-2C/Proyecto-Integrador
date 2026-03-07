
import java.util.Scanner;

public class Main {
    public static final double IVA=0.16;

    public static final double DESCUENTO = 0.10;
    public static final double   UMBRAL_DESCUENTO = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        imprimirFinal(scanner);

    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
    public static double calcularTotal(double pedirDouble){
        double subtotal=pedirDouble+(pedirDouble*IVA);

        if ( pedirDouble> UMBRAL_DESCUENTO) {
            subtotal=pedirDouble - (pedirDouble * DESCUENTO);
        }
        return subtotal;
    }
    public static void imprimirFinal(Scanner msg) {
        double pedirDouble=pedirDouble(msg,"Introduce el subtotal" );
        double calcularTotal=calcularTotal(pedirDouble);
        System.out.println("El total es : "+calcularTotal);
    }
}


