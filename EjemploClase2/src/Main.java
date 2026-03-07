import java.util.Scanner;

public class Main {


    public class main {
        public static void main(String[] args) {
            Ticket ticket = new Ticket();//Declaracion un objeto
            inputValidation inputValidator= new inputValidation();
            Scanner sc = new Scanner(System.in);
//I-P-O
//Input
            int cantidad = inputValidator.getValidInt("Ingresa la cantidad de articulos",sc);
//Process
            ticket.process(cantidad);

//Output
            ticket.imprimirTicket(cantidad);

        }
    }
}
