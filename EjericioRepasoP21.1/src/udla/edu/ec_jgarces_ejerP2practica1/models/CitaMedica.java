package udla.edu.ec_jgarces_ejerP2practica1.models;
import udla.edu.ec_jgarces_ejerP2practica1.enums.EstadoCita;
import udla.edu.ec_jgarces_ejerP2practica1.enums.TipoAfiliacion;
import udla.edu.ec_jgarces_ejerP2practica1.models.Medico;
import udla.edu.ec_jgarces_ejerP2practica1.models.Paciente;
import udla.edu.ec_jgarces_ejerP2practica1.models.Cirujano;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica {
    private final String id;
    private final LocalDate fecha;
    private final LocalTime hora;
    private final Medico medico;
    private final Paciente paciente;
    private EstadoCita estado;
    private final double costoBase;

    public CitaMedica(String id, LocalDate fecha, LocalTime hora, Medico medico,
                      Paciente paciente, double costoBase) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.estado = EstadoCita.PROGRAMADA;
        this.costoBase = costoBase;
        boolean esEmergencia = paciente.isEsEmergencia();
    }

    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public Medico getMedico() { return medico; }
    public Paciente getPaciente() { return paciente; }
    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) { this.estado = estado; }

    public double calcularCosto() {
        double costo = costoBase;

        // Aplicar costo adicional para cirujanos
        if (medico instanceof Cirujano) {
            costo *= 1.30; // 30% adicional
        }

        // Aplicar descuento para pacientes POS
        if (paciente.getAfiliacion() == TipoAfiliacion.POS) {
            costo *= 0.80; // 20% de descuento
        }

        return costo;
    }

    public void mostrarInfo() {
        System.out.println("Cita #" + id + " - Fecha: " + fecha + " " + hora +
                "\n  Médico: " + medico.getNombre() +
                "\n  Paciente: " + paciente.getNombre() +
                "\n  Estado: " + estado +
                "\n  Costo: $" + String.format("%.2f", calcularCosto()));
    }
}