package udla.edu.ec_jgarces_ejerP2practica1.services;
import udla.edu.ec_jgarces_ejerP2practica1.models.*;
import udla.edu.ec_jgarces_ejerP2practica1.enums.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class SistemaDeGestionHospital {
    private List<PersonalGeneral> personalMedico;
    private List<Paciente> pacientes;
    private List<CitaMedica> citas;
    private Scanner scanner;

    public SistemaDeGestionHospital() {
        this.personalMedico = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE GESTIÓN HOSPITALARIA ===");
            System.out.println("1. Registrar personal médico");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Programar cita");
            System.out.println("4. Calcular costo de consulta");
            System.out.println("5. Generar reporte de pacientes por médico");
            System.out.println("6. Buscar personal médico");
            System.out.println("7. Calcular ingresos totales");
            System.out.println("8. Mostrar todas las citas");
            System.out.println("9. Mostrar todo el personal médico");
            System.out.println("10. Mostrar todos los pacientes");
            System.out.println("11. Cambiar estado de cita");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: registrarPersonalMedico(); break;
                case 2: registrarPaciente(); break;
                case 3: programarCita(); break;
                case 4: calcularCostoConsulta(); break;
                case 5: generarReportePacientesPorMedico(); break;
                case 6: buscarPersonalMedico(); break;
                case 7: calcularIngresosTotales(); break;
                case 8: mostrarTodasLasCitas(); break;
                case 9: mostrarTodoPersonalMedico(); break;
                case 10: mostrarTodosLosPacientes(); break;
                case 11: cambiarEstadoCita(); break;
                case 12:
                    System.out.println("¡Gracias por usar el sistema!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void registrarPersonalMedico() {
        System.out.println("\n--- REGISTRAR PERSONAL MÉDICO ---");
        System.out.println("1. Médico");
        System.out.println("2. Cirujano");
        System.out.println("3. Enfermero");
        System.out.print("Seleccione tipo: ");

        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        switch (tipo) {
            case 1: // Médico
                System.out.print("Especialidad: ");
                String especialidad = scanner.nextLine();

                System.out.print("Años de experiencia: ");
                int añosExp = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Licencia médica: ");
                String licencia = scanner.nextLine();

                Medico medico = new Medico(nombre, id, especialidad, añosExp, licencia);
                personalMedico.add(medico);
                System.out.println("¡Médico registrado exitosamente!");
                break;

            case 2: // Cirujano
                System.out.print("Especialidad: ");
                String espCirujano = scanner.nextLine();

                System.out.print("Sub-especialidad: ");
                String subEspecialidad = scanner.nextLine();

                System.out.print("Años de experiencia: ");
                int añosExpCirujano = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Años en cirugía: ");
                int añosCirugia = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Licencia médica: ");
                String licenciaCirujano = scanner.nextLine();

                Cirujano cirujano = new Cirujano(nombre, id, espCirujano, añosExpCirujano,
                        licenciaCirujano, subEspecialidad, añosCirugia);
                personalMedico.add(cirujano);
                System.out.println("¡Cirujano registrado exitosamente!");
                break;

            case 3: // Enfermero
                System.out.println("Turnos disponibles: MAÑANA, TARDE, NOCHE");
                System.out.print("Turno: ");
                String turnoStr = scanner.nextLine().toUpperCase();

                Turno turno;
                try {
                    turno = Turno.valueOf(turnoStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Turno no válido. Se asignará MAÑANA por defecto.");
                    turno = Turno.MAÑANA;
                }

                System.out.print("Área asignada: ");
                String area = scanner.nextLine();

                Enfermero enfermero = new Enfermero(nombre, id, turno, area);
                personalMedico.add(enfermero);
                System.out.println("¡Enfermero registrado exitosamente!");
                break;

            default:
                System.out.println("Tipo no válido.");
                return;
        }
    }

    private void registrarPaciente() {
        System.out.println("\n--- REGISTRAR NUEVO PACIENTE ---");

        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.println("Tipos de afiliación disponibles:");
        for (TipoAfiliacion ta : TipoAfiliacion.values()) {
            System.out.println("- " + ta);
        }
        System.out.print("Tipo de afiliación: ");
        String afiliacionStr = scanner.nextLine().toUpperCase();

        try {
            TipoAfiliacion afiliacion = TipoAfiliacion.valueOf(afiliacionStr);
            Paciente nuevoPaciente = new Paciente(id, nombre, edad, afiliacion);
            pacientes.add(nuevoPaciente);

            System.out.println("¡Paciente registrado exitosamente!");
            nuevoPaciente.mostrarInfo();

        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de afiliación no válido. Registro cancelado.");
        }
    }

    private void programarCita() {
        if (personalMedico.isEmpty() || pacientes.isEmpty()) {
            System.out.println("Error: Debe registrar al menos un médico y un paciente antes de programar citas.");
            return;
        }

        System.out.println("\n--- PROGRAMAR CITA ---");

        // Mostrar pacientes
        System.out.println("Pacientes disponibles:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNombre() + " (ID: " + pacientes.get(i).getId() + ")");
        }
        System.out.print("Seleccione paciente: ");
        int idxPaciente = scanner.nextInt() - 1;

        if (idxPaciente < 0 || idxPaciente >= pacientes.size()) {
            System.out.println("Selección de paciente no válida.");
            return;
        }

        // Mostrar médicos (solo médicos y cirujanos)
        System.out.println("\nMédicos disponibles:");
        List<Medico> medicos = new ArrayList<>();
        int contador = 1;
        for (PersonalGeneral pm : personalMedico) {
            if (pm instanceof Medico) {
                medicos.add((Medico) pm);
                System.out.print(contador + ". " + pm.getNombre() + " (" + ((Medico) pm).getEspecialidad());
                if (pm instanceof Cirujano) {
                    System.out.print(" - Cirujano");
                }
                System.out.println(")");
                contador++;
            }
        }

        if (medicos.isEmpty()) {
            System.out.println("No hay médicos registrados en el sistema.");
            return;
        }

        System.out.print("Seleccione médico: ");
        int idxMedico = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (idxMedico < 0 || idxMedico >= medicos.size()) {
            System.out.println("Selección de médico no válida.");
            return;
        }

        Medico medicoSeleccionado = medicos.get(idxMedico);

        // Datos de la cita
        System.out.print("Ingrese fecha (yyyy-mm-dd): ");
        String fechaStr = scanner.nextLine();

        // Verificar si es cirujano y fin de semana
        if (medicoSeleccionado instanceof Cirujano) {
            try {
                LocalDate fecha = LocalDate.parse(fechaStr);
                if (fecha.getDayOfWeek().getValue() >= 6) { // 6=Sábado, 7=Domingo
                    System.out.println("Error: Los cirujanos no atienden los fines de semana.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Fecha no válida.");
                return;
            }
        }

        System.out.print("Ingrese hora (HH:mm): ");
        String horaStr = scanner.nextLine();

        System.out.print("¿Es emergencia? (si/no): ");
        boolean esEmergencia = scanner.nextLine().equalsIgnoreCase("si");

        System.out.print("Costo base de la consulta: ");
        double costoBase = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        try {
            LocalDate fecha = LocalDate.parse(fechaStr);
            LocalTime hora = LocalTime.parse(horaStr);

            // Crear cita
            String idCita = "C" + (citas.size() + 1);
            Paciente paciente = pacientes.get(idxPaciente);
            paciente.setEsEmergencia(esEmergencia);

            CitaMedica cita = new CitaMedica(idCita, fecha, hora, medicoSeleccionado, paciente, costoBase);
            citas.add(cita);

            System.out.println("¡Cita programada exitosamente!");
            cita.mostrarInfo();

        } catch (Exception e) {
            System.out.println("Error en el formato de fecha u hora. Use formato yyyy-mm-dd para fecha y HH:mm para hora.");
        }
    }

    private void calcularCostoConsulta() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }

        System.out.println("\n--- CALCULAR COSTO DE CONSULTA ---");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println((i + 1) + ". Cita #" + citas.get(i).getId() + " - " +
                    citas.get(i).getPaciente().getNombre() + " con Dr. " +
                    citas.get(i).getMedico().getNombre());
        }
        System.out.print("Seleccione cita: ");
        int idxCita = scanner.nextInt() - 1;

        if (idxCita < 0 || idxCita >= citas.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        CitaMedica cita = citas.get(idxCita);
        double costo = cita.calcularCosto();

        System.out.println("\nDetalle del costo para la cita #" + cita.getId() + ":");
        System.out.println("Costo base: $" + String.format("%.2f", cita.calcularCosto() /
                (cita.getMedico() instanceof Cirujano ? 1.3 : 1.0) /
                (cita.getPaciente().getAfiliacion() == TipoAfiliacion.POS ? 0.8 : 1.0)));

        if (cita.getMedico() instanceof Cirujano) {
            System.out.println("Adicional cirujano (30%): +$" +
                    String.format("%.2f", cita.calcularCosto() / 1.3 * 0.3));
        }

        if (cita.getPaciente().getAfiliacion() == TipoAfiliacion.POS) {
            System.out.println("Descuento POS (20%): -$" +
                    String.format("%.2f", cita.calcularCosto() / 0.8 * 0.2));
        }

        System.out.println("TOTAL: $" + String.format("%.2f", costo));
    }

    private void generarReportePacientesPorMedico() {
        System.out.println("\n--- REPORTE DE PACIENTES POR MÉDICO ---");

        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }

        Map<String, List<String>> reporte = new HashMap<>();

        for (CitaMedica cita : citas) {
            String medico = cita.getMedico().getNombre();
            String paciente = cita.getPaciente().getNombre();

            reporte.putIfAbsent(medico, new ArrayList<>());
            if (!reporte.get(medico).contains(paciente)) {
                reporte.get(medico).add(paciente);
            }
        }

        if (reporte.isEmpty()) {
            System.out.println("No hay datos para mostrar.");
            return;
        }

        for (Map.Entry<String, List<String>> entry : reporte.entrySet()) {
            System.out.println("\nMédico: " + entry.getKey());
            System.out.println("Pacientes atendidos:");
            for (String paciente : entry.getValue()) {
                System.out.println("  - " + paciente);
            }
        }
    }

    private void buscarPersonalMedico() {
        System.out.println("\n--- BUSCAR PERSONAL MÉDICO ---");
        System.out.println("1. Buscar por especialidad");
        System.out.println("2. Buscar por turno (enfermeros)");
        System.out.print("Seleccione opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese especialidad: ");
                String especialidad = scanner.nextLine();

                System.out.println("\nMédicos de " + especialidad + ":");
                boolean encontrado = false;
                for (PersonalGeneral pm : personalMedico) {
                    if (pm instanceof Medico && ((Medico) pm).getEspecialidad().equalsIgnoreCase(especialidad)) {
                        pm.mostrarInfo();
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontraron médicos con esa especialidad.");
                }
                break;

            case 2:
                System.out.println("Turnos disponibles: MAÑANA, TARDE, NOCHE");
                System.out.print("Ingrese turno: ");
                String turnoStr = scanner.nextLine().toUpperCase();

                try {
                    Turno turno = Turno.valueOf(turnoStr);
                    System.out.println("\nEnfermeros del turno " + turno + ":");
                    boolean encontradoEnf = false;
                    for (PersonalGeneral pm : personalMedico) {
                        if (pm instanceof Enfermero && ((Enfermero) pm).getTurno() == turno) {
                            pm.mostrarInfo();
                            encontradoEnf = true;
                        }
                    }
                    if (!encontradoEnf) {
                        System.out.println("No se encontraron enfermeros en ese turno.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Turno no válido.");
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private void calcularIngresosTotales() {
        System.out.println("\n--- INGRESOS TOTALES DEL HOSPITAL ---");

        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }

        double ingresosTotales = 0;
        double ingresosCirujanos = 0;
        double ingresosMedicos = 0;

        for (CitaMedica cita : citas) {
            if (cita.getEstado() == EstadoCita.COMPLETADA) {
                double costo = cita.calcularCosto();
                ingresosTotales += costo;

                if (cita.getMedico() instanceof Cirujano) {
                    ingresosCirujanos += costo;
                } else {
                    ingresosMedicos += costo;
                }
            }
        }

        System.out.println("Ingresos totales: $" + String.format("%.2f", ingresosTotales));
        System.out.println("Ingresos por cirujanos: $" + String.format("%.2f", ingresosCirujanos));
        System.out.println("Ingresos por médicos: $" + String.format("%.2f", ingresosMedicos));

        // Mostrar citas completadas vs totales
        long citasCompletadas = citas.stream().filter(c -> c.getEstado() == EstadoCita.COMPLETADA).count();
        System.out.println("Citas completadas: " + citasCompletadas + " de " + citas.size() + " totales");
    }

    private void mostrarTodasLasCitas() {
        System.out.println("\n--- TODAS LAS CITAS ---");
        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }

        for (CitaMedica cita : citas) {
            cita.mostrarInfo();
            System.out.println("---");
        }
    }

    private void mostrarTodoPersonalMedico() {
        System.out.println("\n--- TODO EL PERSONAL MÉDICO ---");
        if (personalMedico.isEmpty()) {
            System.out.println("No hay personal médico registrado.");
            return;
        }

        System.out.println("MÉDICOS:");
        for (PersonalGeneral pm : personalMedico) {
            if (pm instanceof Medico && !(pm instanceof Cirujano)) {
                pm.mostrarInfo();
            }
        }

        System.out.println("\nCIRUJANOS:");
        for (PersonalGeneral pm : personalMedico) {
            if (pm instanceof Cirujano) {
                pm.mostrarInfo();
            }
        }

        System.out.println("\nENFERMEROS:");
        for (PersonalGeneral pm : personalMedico) {
            if (pm instanceof Enfermero) {
                pm.mostrarInfo();
            }
        }
    }

    private void mostrarTodosLosPacientes() {
        System.out.println("\n--- TODOS LOS PACIENTES ---");
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        for (Paciente paciente : pacientes) {
            paciente.mostrarInfo();
        }
    }

    private void cambiarEstadoCita() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }

        System.out.println("\n--- CAMBIAR ESTADO DE CITA ---");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println((i + 1) + ". Cita #" + citas.get(i).getId() + " - " +
                    citas.get(i).getPaciente().getNombre() + " - Estado: " +
                    citas.get(i).getEstado());
        }
        System.out.print("Seleccione cita: ");
        int idxCita = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (idxCita < 0 || idxCita >= citas.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        System.out.println("Estados disponibles: PROGRAMADA, COMPLETADA, CANCELADA");
        System.out.print("Nuevo estado: ");
        String estadoStr = scanner.nextLine().toUpperCase();

        try {
            EstadoCita nuevoEstado = EstadoCita.valueOf(estadoStr);
            citas.get(idxCita).setEstado(nuevoEstado);
            System.out.println("Estado actualizado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido.");
        }
    }
}
