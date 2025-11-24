package udla.jgarces.ejer12;

public class Libro extends MaterialLectura {
    private String isbn;

    public Libro(String titulo, String autor, int año, Estado estado, String isbn) {
        super(titulo, autor, año, estado);
        this.isbn = isbn;
    }

    public String getIsbn() { return isbn; }

    public void mostrarInfo() {
        System.out.println("📚 Libro: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Año: " + año);
        System.out.println("   Estado: " + estado);
        System.out.println("   ISBN: " + isbn);
    }
}