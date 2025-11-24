package udla.jgarces.ejer12;

public abstract class MaterialLectura {
    protected String titulo;
    protected String autor;
    protected int año;
    protected Estado estado;

    public MaterialLectura(String titulo, String autor, int año, Estado estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.estado = estado;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAño() { return año; }
    public Estado getEstado() { return estado; }

    public abstract void mostrarInfo();
}