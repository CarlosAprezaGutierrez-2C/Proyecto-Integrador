import java.util.Scanner;

public class PersonaService {

    private  boolean existeId(Persona [] persona,int id){

        for(Persona persona1:persona){
            if (persona1!=null && persona1.getId()==id)
                return true;

        }
        return false;
    }

    public void altaPersona(Scanner sc, Persona[] personaS) {
        int id;
        double promedio=0;
        String nombrePersona;
        do{
            System.out.print("Ingresa el id de la persona que sera dada de alta: ");
            if (!sc.hasNextInt()) {
                System.out.println("Error: el id debe ser un número entero");
                sc.nextLine();
                return;
            }
            id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.out.println("El id debe ser mayor que 0");
                return;
            }
            if (existeId(personaS,id)) {
                System.out.println("El id que desean registrar ya existe");
            }
        } while (existeId(personaS, id));{
        }


        do {
            System.out.println("Ingresa el nombre de la persona que deseas registrar:");
            nombrePersona = sc.nextLine().trim();

            if (nombrePersona.isEmpty()) {
                System.out.println("Debes ingresar un nombre válido");
            }

        } while (nombrePersona.isEmpty());

        do{
            System.out.println("Ingresa el promedio de la persona que deseas registrar (0-10):");

            if (!sc.hasNextDouble()) {
                System.out.println("Error: el promedio debe ser numérico");
                sc.nextLine();
                continue;
            }
            promedio = sc.nextDouble();
            sc.nextLine();

            if (promedio < 0 || promedio > 10) {
                System.out.println("El promedio debe ser mayor que 0 y maximo de 10");
            }
        } while (promedio < 0 || promedio > 10);

        for (int i = 0; i < personaS.length; i++) {
            if (personaS[i] == null) {
                personaS[i] = new Persona(id, nombrePersona, promedio);
                System.out.println("Registrado exitosamente");
                return;
            }
        }

        System.out.println("No hay espacio disponible para registrar más personas");
    }

    public void buscarPersona(Scanner sc ,Persona[] personaS){
        System.out.println("Ingresa el id de la persona que deseas buscar");
        int id=sc.nextInt();
        if (!sc.hasNextInt()) {
            System.out.println("Error el id debe contener unicamente numeros enteros");
            sc.nextLine();
            return;
        }
        for (Persona persona1:personaS){
            if (persona1!=null && persona1.getId()==id && persona1.isActivo()){
                System.out.println("La informacion de la persona que estas buscando es : "+persona1);
                return;
            }

        }
        System.out.println("El id que deseas buscar no se encuentra registrado");

    }

    public void bajaLogica (Scanner sc ,Persona[] personaS){
        System.out.println("Ingresa el id de la persona que deseas eliminar");
        int id=sc.nextInt();
        sc.nextLine();
        if(!sc.hasNextInt()){
            System.out.println("Error el id debe contener unicamente numeros enteros");
            sc.nextLine();
            return;
        }
        for (Persona persona1:personaS){
            if (persona1!=null && persona1.getId()==id){
                persona1.setActivo(false);
                System.out.println("Se ha eliminado correctamente la persona");
                sc.nextLine();
                return;
            }

        }
        System.out.println("No se ha podido ");
    }


    public void listarPersonas(Persona[] personaS){

        for (Persona persona1:personaS){
            if (persona1!=null && persona1.isActivo()){
                System.out.println(persona1);
            }
        }
    }

    public void actualizarPromedio(Persona[] personaS,Scanner sc){
        System.out.println("Ingresa el id de la persona que deseas actualizar");
        int id=sc.nextInt();
        sc.nextLine();
        if (sc.hasNextInt()){
            System.out.println("Error el id debe incluir unicamente numeros enteros");
            sc.nextLine();
            return;
        }
        for (Persona persona1:personaS){
            if (persona1!=null && persona1.getId()==id && persona1.isActivo()){
                System.out.println("Introduce el promedio de la persona");
                double Promedio=sc.nextDouble();
                if (!sc.hasNextDouble()){
                    System.out.println("Error ingresa el promedio de la persona correctamente numeros con decimales");
                }
                persona1.setPromedio(Promedio);
                System.out.println("Se ha actualizado correctamente la calificacion de la persona");
                sc.nextLine();
                return;
            }
            System.out.println("No se ha podido registrar el nommbre de la persona");
        }
    }


    public void reportes(Persona[] personas) {

        double suma = 0;
        int contador = 0;
        int mayoresA8 = 0;

        Persona mayor = null;
        Persona menor = null;

        for (Persona p : personas) {
            if (p != null && p.isActivo()) {

                double prom = p.getPromedio();
                suma += prom;
                contador++;

                if (prom >= 8.0) {
                    mayoresA8++;
                }

                if (mayor == null || prom > mayor.getPromedio()) {
                    mayor = p;
                }

                if (menor == null || prom < menor.getPromedio()) {
                    menor = p;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        double promedioGeneral = suma / contador;

        System.out.println(" REPORTES ");
        System.out.println("Promedio general: " + promedioGeneral);
        System.out.println("Mayor promedio: " + mayor);
        System.out.println("Menor promedio: " + menor);
        System.out.println("Cantidad con promedio mayores a8: " + mayoresA8);
    }

}
