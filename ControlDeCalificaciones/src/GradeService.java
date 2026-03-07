public class GradeService {
    static double promedioParciales;


    //CALCULAR PROMEDIO
    public  double calcularPromedio(double a, double b, double c){
        return promedioParciales=(a+b+c)/3;
    }

    // CALCULAR PROMEDIO FINAL
    public  double calcularFinal(double promedio, int asistencia){
        double calificacionFinal;

    return calificacionFinal=(promedioParciales*0.7)+(asistencia*0.3);
    }

    //VERIFICAR SI PASO O NO
    public static String determinarEstado(double finall, int asistencia, boolean entregoProyecto){
     if (asistencia<80){
     return "REPROBADO POR ASISTENCIA";
     }else if (!entregoProyecto){
         return "REPROBADO POR NO ENTREGAR EL PROYECTO";
     }
     if (finall<70){
         return "REPROBADO POR CALIFICACION NO APROBATORIA";
     }else{
       return "Aprobatorio ";
     }
    }
    }


