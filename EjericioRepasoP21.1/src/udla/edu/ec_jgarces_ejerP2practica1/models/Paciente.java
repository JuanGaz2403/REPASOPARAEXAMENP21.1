package udla.edu.ec_jgarces_ejerP2practica1.models;
import udla.edu.ec_jgarces_ejerP2practica1.enums.TipoAfiliacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String id;
    private String nombre;
    private int edad;
    private TipoAfiliacion afiliacion;
    private List<String> historialMedico;
    private boolean esEmergencia;

    public Paciente(String id, String nombre, int edad, TipoAfiliacion afiliacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.afiliacion = afiliacion;
        this.historialMedico = new ArrayList<>();
        this.esEmergencia = false;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public TipoAfiliacion getAfiliacion() { return afiliacion; }
    public boolean isEsEmergencia() { return esEmergencia; }
    public void setEsEmergencia(boolean esEmergencia) { this.esEmergencia = esEmergencia; }

    public void agregarConsultaHistorial(String consulta) {
        historialMedico.add(LocalDate.now() + ": " + consulta);
    }

    public void mostrarHistorial() {
        System.out.println("Historial médico de " + nombre + ":");
        for (String consulta : historialMedico) {
            System.out.println("  - " + consulta);
        }
    }

    public void mostrarInfo() {
        System.out.println("Paciente: " + nombre + " - Edad: " + edad + " - Afiliación: " + afiliacion + " - ID: " + id);
    }
}