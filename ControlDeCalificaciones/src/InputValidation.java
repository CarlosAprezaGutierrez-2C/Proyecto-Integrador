import java.util.Scanner;

public class InputValidation {

    GradeService boleto = new GradeService();

    public String leerTextoNoVacio(Scanner sc, String msg){
        String texto;
        while (true){
            System.out.println(msg);
            texto=sc.nextLine().trim();
            if (texto.isEmpty()){
                System.out.println("Por favor ingrese un texto");
            }else {
                return texto;
            }
        }
    }
    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double promedio;
        while (true){
            System.out.println(msg);

            if (sc.hasNextDouble()){
                promedio=sc.nextDouble();
                sc.nextLine();
                if (promedio<min || promedio>max){
                    System.out.println("El promedio es incorrecto debe estar entre "+min+" y debe ser menor a : "+max);
                } else  {
                    return promedio;
                }
            }else{
                System.out.println("Por favor ingrese un dato valido solo se aceptan numeros con decimales");
                sc.nextLine();
            }


        }
    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max){
        int asistencia;
        while (true){
            System.out.println(msg);
            if (sc.hasNextInt()){
                asistencia=sc.nextInt();
                sc.nextLine();
                if (asistencia<min || asistencia>max){
                    System.out.println("Error la asistencia no debe ser mayor a:"+min+"y debe ser menor a "+max);
                }else
                    return asistencia;
            }else {
                System.out.println("Por favor ingrese un dato valido solo se aceptan numeros sin decimales");
                sc.nextLine();
            }
        }

    }
    public boolean leerBoolean(Scanner sc, String msg){
        boolean entregaProyecto=true;
        while (true){
            System.out.println(msg);
            if (sc.hasNextBoolean()){
                entregaProyecto=sc.nextBoolean();
                sc.nextLine();
                return entregaProyecto;
            }else{
                System.out.println("Ingresa un valor valido solo se aceptan true/false");
                sc.nextLine();
            }
        }
    }

}

