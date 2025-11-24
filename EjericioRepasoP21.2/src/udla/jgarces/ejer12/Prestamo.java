package udla.jgarces.ejer12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private MaterialLectura material;
    private Usuarios usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(MaterialLectura material, Usuarios usuario) {
        this.material = material;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(10); // 10 días para devolver
    }

    public MaterialLectura getMaterial() { return material; }
    public Usuarios getUsuario() { return usuario; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    public void mostrarInfo() {
        System.out.println("📋 Préstamo:");
        System.out.println("   Material: " + material.getTitulo());
        System.out.println("   Usuario: " + usuario.getNombre());
        System.out.println("   Fecha préstamo: " + fechaPrestamo);
        System.out.println("   Fecha devolución: " + fechaDevolucion);
    }
}