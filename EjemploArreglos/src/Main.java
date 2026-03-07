public class Main {

    public static void main(String[] args) {

        // Declaración
        int[] arr;

        // Inicialización
        int[] arr1 = new int[4];
        int[] arr2 = {1, 2, 3, 4};

        // Acceso (Get)
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        // Recorrido tradicional
        System.out.println("___________________");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        // Recorrido for-each
        System.out.println("___________________");
        for (int numero : arr1) {
            System.out.println(numero);
        }

        System.out.println("__________");

        // Arreglo de objetos
        Persona[] personas = new Persona[3];

        Persona persona1 = new Persona();
        persona1.setId(1);
        persona1.setName("Test");
        persona1.setActive(true);

        Persona persona2 = new Persona(2, "Eliel");
        Persona persona3 = new Persona(3, "David");

        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;

        // Eliminamos el primer elemento
        personas[0] = null;

        // Recorrido seguro
        for (Persona persona : personas) {

            if (persona == null) {
                System.out.println("Hay un null");
            } else {
                System.out.println(persona);
            }
        }
    }
}
