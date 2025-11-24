package udla.edu.ec_jgarces_ejerP2practica1.models;
import udla.edu.ec_jgarces_ejerP2practica1.enums.Turno;
import udla.edu.ec_jgarces_ejerP2practica1.models.PersonalGeneral;
import udla.edu.ec_jgarces_ejerP2practica1.models.Paciente;

public class Enfermero extends PersonalGeneral {
    private Turno turno;
    private String areaAsignada;

    public Enfermero(String nombre, String id, Turno turno, String areaAsignada) {
        super(nombre, id);
        this.turno = turno;
        this.areaAsignada = areaAsignada;
    }

    public Turno getTurno() { return turno; }
    public String getAreaAsignada() { return areaAsignada; }

    public void administrarMedicamentos(Paciente paciente, String medicamento) {
        System.out.println("Enf. " + nombre + " administra: " + medicamento + " a " + paciente.getNombre());
    }

    public void tomarSignosVitales(Paciente paciente, String signos) {
        System.out.println("Enf. " + nombre + " toma signos vitales: " + signos + " a " + paciente.getNombre());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Enfermero: " + nombre + " - Turno: " + turno + " - Área: " + areaAsignada);
    }
}