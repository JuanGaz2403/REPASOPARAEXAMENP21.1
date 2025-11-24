public class Alumno extends Persona {
    private int id;
    private double nota1;
    private double nota2;
    private double nota3;
    private static int contadorId = 1; // Contador estático para asignar IDs únicos

    // Constructor
    public Alumno(String nombre, String apellido, int edad, String genero, double nota1, double nota2, double nota3) {
        super(nombre, apellido, edad, genero);
        // Asignar y autoincrementar el ID
        this.id = contadorId++;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Getter para el ID
    public int getId() {
        return id;
    }

    // Getter para calcular el promedio
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Sobrescritura (sin usar @Override) para mostrar toda la información del alumno
    public void mostrarInfo() {
        System.out.println("\n--- Info Alumno (ID: " + id + ") ---");
        super.mostrarInfo(); // Llama al método de la superclase
        System.out.println("  Nota 1: " + nota1);
        System.out.println("  Nota 2: " + nota2);
        System.out.println("  Nota 3: " + nota3);
        System.out.printf("  Promedio: %.2f\n", calcularPromedio());
    }
}