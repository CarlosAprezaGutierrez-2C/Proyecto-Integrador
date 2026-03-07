import java.util.Scanner;

public class Main {

    static double subtotal = 0;
    static double iva = 0;
    static double total = 0;

    static double pesoKg;
    static int distanciaKm;
    static boolean esZonaRemota;
    static int tipoServicio;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ShippingCalculator boleto = new ShippingCalculator();
        inputValidation val = new inputValidation();

        // INPUT
        pesoKg = val.leerDoubleEnRango(input, "Ingresa el peso en kg (0.1 - 50)", 0.1, 50.0);
        distanciaKm = val.leerIntEnRango(input, "Ingresa la distancia en km (1 - 2000)", 1, 2000);
        esZonaRemota = val.leerBoolean(input, "¿Es zona remota? (true/false)");

        tipoServicio = val.leerIntEnRango(input, "Tipo de servicio (1 = Estándar, 2 = Express)", 1, 2);



        // PROCESO
        boleto.setPesoKg(pesoKg);
        boleto.setDistanciaKm(distanciaKm);
        boleto.setEsZonaRemota(esZonaRemota);
        boleto.setTipoServicio(tipoServicio);

        subtotal = boleto.calcularSubtotal();
        iva = boleto.calcularIVA(subtotal);
        total = boleto.calcularTotal(subtotal, iva);

        // OUTPUT
        ticket();
    }

    public static void ticket() {
        System.out.println("----- TICKET DE ENVÍO -----");
        System.out.println("El Subtotal de la compra es : $" + subtotal);
        System.out.println("El costo del IVA es : $" + iva);
        System.out.println("El Total a pagar es : $" + total);
        System.out.println("Gracias por usar este programa ");
        System.out.println("---------------------------");
    }
}
