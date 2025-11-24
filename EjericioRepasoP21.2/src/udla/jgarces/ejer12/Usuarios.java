package udla.jgarces.ejer12;

public class Usuarios {
    private String nombre;
    private int id;
    private String email;
    private TIpousuario tipo;

    public Usuarios(String nombre, int id, String email, TIpousuario tipo) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }
    public String getEmail() { return email; }
    public TIpousuario getTipo() { return tipo; }

    public void mostrarInfo() {
        System.out.println("👤 Usuario: " + nombre);
        System.out.println("   ID: " + id);
        System.out.println("   Email: " + email);
        System.out.println("   Tipo: " + tipo);
    }
}