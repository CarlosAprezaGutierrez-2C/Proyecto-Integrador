import java.util.Scanner;

public class main {
    static String nombre;
    static double calificacion1;
    static double calificacion2;
    static double calificacion3;
    static double promedio;
    static int pedirAsistencia;
    static boolean entregarProyecto;
    static double promedioFinal;
    static String verificarEstado;




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService GS = new GradeService();
        InputValidation Iv = new InputValidation();


        //INPUT


        nombre=Iv.leerTextoNoVacio(sc,"Ingresa el nombre del estudiante");
        calificacion1=Iv.leerDoubleEnRango(sc,"Ingresa la calificacion del parcial #1 (0-100):",0,100);
        calificacion2=Iv.leerDoubleEnRango(sc,"Ingresa la calificacion  del parcial #2 (0-100) : ",0,100);
        calificacion3=Iv.leerDoubleEnRango(sc,"Ingresa la calificacion  del parcial #3 (0-100): ",0,100);
        pedirAsistencia=Iv.leerIntEnRango(sc,"Ingresa el % de la asistencia final solo el valor entero (0-100)",0,100);
        entregarProyecto=Iv.leerBoolean(sc,"El estudiante entrego el proyecto final (true/false)");


        promedio=GS.calcularPromedio(calificacion1,calificacion2,calificacion3);
        promedioFinal=GS.calcularFinal(promedio,pedirAsistencia);
        verificarEstado=GS.determinarEstado(promedioFinal,pedirAsistencia,entregarProyecto);


        imprimirReporte();


    }
    public static void imprimirReporte(){
        System.out.println("---REPORTE FINAL---");
        System.out.println("El nombre del estudiante es :"+nombre);
        System.out.println("La calificacion del parcial #1 es : "+calificacion1);
        System.out.println("La calificacion del parcial #2 es :"+calificacion2);
        System.out.println("La calificacion del parcial #3 es :"+calificacion3);
        System.out.println("El promedio de los parcial es : "+promedio);
        System.out.println("El total de la asistencia es : "+pedirAsistencia+ "%");
        System.out.println("El Alumno entrego el proyecto final : "+entregarProyecto);
        System.out.println("La calificacion fiinal del Alumno es :"+promedioFinal);
        System.out.println("EL ESTADO DEL ALUMNO ES : "+verificarEstado);

    }

}



