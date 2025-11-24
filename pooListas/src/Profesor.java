public class Profesor extends Persona {
    private int id;
    private String materia;
    private static int contadorId = 1; // Contador estático para asignar IDs únicos

    // Constructor
    public Profesor(String nombre, String apellido, int edad, String genero, String materia) {
        super(nombre, apellido, edad, genero);
        // Asignar y autoincrementar el ID
        this.id = contadorId++;
        this.materia = materia;
    }

    // Getter para el ID
    public int getId() {
        return id;
    }

    // Sobrescritura (sin usar @Override) para mostrar toda la información del profesor
    public void mostrarInfo() {
        System.out.println("\n--- Info Profesor (ID: " + id + ") ---");
        super.mostrarInfo(); // Llama al método de la superclase
        System.out.println("  Materia: " + materia);
    }
}