package udla.edu.ec_jgarces_ejerP2practica1.models;

public class Medico extends PersonalGeneral {
    private String especialidad;
    private int añosExperiencia;
    private String licenciaMedica;

    public Medico(String nombre, String id, String especialidad, int añosExperiencia, String licenciaMedica) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.licenciaMedica = licenciaMedica;
    }

    public String getEspecialidad() { return especialidad; }
    public int getAñosExperiencia() { return añosExperiencia; }
    public String getLicenciaMedica() { return licenciaMedica; }

    public void diagnosticar(Paciente paciente, String diagnostico) {
        System.out.println("Dr. " + nombre + " diagnostica: " + diagnostico + " a " + paciente.getNombre());
    }

    public void prescribirMedicamentos(Paciente paciente, String medicamentos) {
        System.out.println("Dr. " + nombre + " prescribe: " + medicamentos + " a " + paciente.getNombre());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Médico: " + nombre + " - Especialidad: " + especialidad +
                " - Experiencia: " + añosExperiencia + " años - Licencia: " + licenciaMedica);
    }
}