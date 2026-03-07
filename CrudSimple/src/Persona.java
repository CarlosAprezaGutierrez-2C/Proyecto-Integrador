public class Persona {
    private int id;
    private String name;
    private boolean isSctive;

    public Persona() {}

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.isSctive = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isSctive() { return isSctive; }
    public void setSctive(boolean isSctive) { this.isSctive = isSctive; }

    @Override
    public String toString() {
        return "ID" + id + "Nombre" + name + "Estado" + (isSctive ? "Activa" : "Inactiva");
    }
}