package udla.edu.ec_jgarces_ejerP2practica1.models;

public abstract class PersonalGeneral {
    protected String nombre;
    protected String id;

    public PersonalGeneral(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }

    public abstract void mostrarInfo();
}