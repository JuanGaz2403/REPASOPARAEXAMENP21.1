// Persona.java

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;

    // Constructor
    public Persona(String nombre, String apellido, int edad, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    // Método para mostrar información general (puede ser sobrescrito en las subclases)
    public void mostrarInfo() {
        System.out.println("  Nombre: " + nombre + " " + apellido);
        System.out.println("  Edad: " + edad);
        System.out.println("  Género: " + genero);
    }
}