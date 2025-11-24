package udla.jgarces.ejer12;

public class Tesis extends MaterialLectura {
    private String universidad;

    public Tesis(String titulo, String autor, int año, Estado estado, String universidad) {
        super(titulo, autor, año, estado);
        this.universidad = universidad;
    }

    public String getUniversidad() { return universidad; }

    public void mostrarInfo() {
        System.out.println("🎓 Tesis: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Año: " + año);
        System.out.println("   Estado: " + estado);
        System.out.println("   Universidad: " + universidad);
    }
}