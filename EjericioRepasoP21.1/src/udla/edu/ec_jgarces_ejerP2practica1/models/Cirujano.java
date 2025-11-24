package udla.edu.ec_jgarces_ejerP2practica1.models;
import udla.edu.ec_jgarces_ejerP2practica1.models.Medico;
import udla.edu.ec_jgarces_ejerP2practica1.models.Paciente;
import java.time.LocalDate;

public class Cirujano extends Medico {
    private String subEspecialidad;
    private int añosCirugia;

    public Cirujano(String nombre, String id, String especialidad, int añosExperiencia,
                    String licenciaMedica, String subEspecialidad, int añosCirugia) {
        super(nombre, id, especialidad, añosExperiencia, licenciaMedica);
        this.subEspecialidad = subEspecialidad;
        this.añosCirugia = añosCirugia;
    }

    public String getSubEspecialidad() { return subEspecialidad; }
    public int getAñosCirugia() { return añosCirugia; }

    public void programarCirugia(Paciente paciente, String tipoCirugia, LocalDate fecha) {
        System.out.println("Cirujano " + nombre + " programa cirugía " + tipoCirugia +
                " para " + paciente.getNombre() + " el " + fecha);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cirujano: " + nombre + " - Especialidad: " + getEspecialidad() +
                " - Sub-especialidad: " + subEspecialidad + " - Años en cirugía: " + añosCirugia);
    }
}