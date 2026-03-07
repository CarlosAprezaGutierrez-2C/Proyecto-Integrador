import java.util.Scanner;

public class main {


        public static void main(String[] args) {
            Scanner leer = new Scanner(System.in);

           imprimirTicket(leer);
        }
        public static double pedirMensaje(Scanner scanner,String mensaje) {

            System.out.println(mensaje);
           return scanner.nextDouble();
        }
        public static double calcularSuma(double num1, double num2, double num3) {

            return num1+num2+num3;
        }
        public static double calcularPromedio (double suma) {
            return suma / 3.0;
        }
        public static void imprimirTicket (Scanner leer) {
            double Numero1=pedirMensaje(leer,"Ingresa un numero1");
            double Numero2=pedirMensaje(leer,"Ingresa el numero2");
            double Numero3=pedirMensaje(leer,"Ingresa el numero3");
            double calcularSuma=calcularSuma(Numero1,Numero2,Numero3);
            double calcularPromedio=calcularPromedio(calcularSuma);
            System.out.println("La suma es: "+calcularSuma);
            System.out.println("El promedio es: "+calcularPromedio);
        }

    }

