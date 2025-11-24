package udla.jgarces.ejer12;

public class Revista extends MaterialLectura {
    private int numeroEdicion;

    public Revista(String titulo, String autor, int año, Estado estado, int numeroEdicion) {
        super(titulo, autor, año, estado);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() { return numeroEdicion; }

    public void mostrarInfo() {
        System.out.println("📰 Revista: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Año: " + año);
        System.out.println("   Estado: " + estado);
        System.out.println("   Edición: " + numeroEdicion);
    }
}