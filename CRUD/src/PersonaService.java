import java.util.Scanner;

public class PersonaService {
    private boolean existeId(Persona[] personas, int id) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void alta(Scanner sc, Persona[] personas) {
        System.out.println("alta de Persona");
        System.out.print("ingresa el id");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("el id debe ser mayor que 0 ");
            return;
        }

        if (existeId(personas, id)) {
            System.out.println("ya existe el id ");
            return;
        }

        System.out.print("ingresa el nombre");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("no hay caracteres");
            return;
        }


        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Registro echo");
                return;
            }
        }
    }

    public void buscar(Scanner sc, Persona[] personas) {
        System.out.print("Id para buscar a personas ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isSctive()) {
                System.out.println("Resultado" + p);
                return;
            }
        }
        System.out.println("no hay persona ");
    }

    public void bajaLogica(Scanner sc, Persona[] personas) {
        System.out.print("pon el id para dar baja ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                p.setSctive(false);
                System.out.println("baja realizada ");
                return;
            }
        }
        System.out.println("no fue encontrado");
    }

    public void listarActivas(Persona[] personas) {
        System.out.println("personas que estan activas");
        for (Persona p : personas) {
            if (p != null && p.isSctive()) {
                System.out.println(p);
            }
        }
    }

    public void actualizarNombre(Scanner sc, Persona[] personas) {
        System.out.print("pon el ID  a actualizar  ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isSctive()) {
                System.out.print("nuevo nombre ");
                String nuevoNombre = sc.nextLine();
                if (!nuevoNombre.trim().isEmpty()) {
                    p.setName(nuevoNombre);
                    System.out.println("ya fue actualizado");
                } else {
                    System.out.println("el nombre es invalido");
                }
                return;
            }
        }
        System.out.println("No se puede actualizar");
    }
}