import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Listas para almacenar alumnos y profesores
    private static List<Alumno> listaAlumnos = new ArrayList<>();
    private static List<Profesor> listaProfesores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea pendiente

                switch (opcion) {
                    case 1:
                        ingresarAlumno();
                        break;
                    case 2:
                        ingresarProfesor();
                        break;
                    case 3:
                        eliminarAlumno();
                        break;
                    case 4:
                        eliminarProfesor();
                        break;
                    case 5:
                        desplegarTodo();
                        break;
                    case 6:
                        System.out.println("\n Saliendo de la aplicación. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\n Opción no válida. Inténtelo de nuevo.");
                }
            } else {
                System.out.println("\n Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Consumir la entrada no válida
                opcion = 0; // Para que el bucle continúe
            }

            if (opcion != 6) {
                System.out.println("\n-------------------------------------------");
            }

        } while (opcion != 6);

        scanner.close();
    }

    // --- Métodos de Interfaz ---

    private static void mostrarMenu() {
        System.out.println("\n===========================================");
        System.out.println("          SISTEMA DE GESTIÓN ESCOLAR");
        System.out.println("===========================================");
        System.out.println("1.  Ingresar Nuevo Alumno");
        System.out.println("2.  Ingresar Nuevo Profesor");
        System.out.println("3.  Eliminar Alumno por ID");
        System.out.println("4.  Eliminar Profesor por ID");
        System.out.println("5.  Desplegar Todos (Alumnos y Profesores)");
        System.out.println("6.  Salir");
        System.out.print(">>> Ingrese su opción: ");
    }

    // --- Métodos de Gestión ---

    private static void ingresarAlumno() {
        System.out.println("\n--- Ingreso de Nuevo Alumno ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Nota 1: ");
        double n1 = scanner.nextDouble();
        System.out.print("Nota 2: ");
        double n2 = scanner.nextDouble();
        System.out.print("Nota 3: ");
        double n3 = scanner.nextDouble();
        scanner.nextLine();

        Alumno nuevoAlumno = new Alumno(nombre, apellido, edad, genero, n1, n2, n3);
        listaAlumnos.add(nuevoAlumno);
        System.out.println("\n Alumno ingresado con éxito. ID asignado: " + nuevoAlumno.getId());
    }

    private static void ingresarProfesor() {
        System.out.println("\n--- Ingreso de Nuevo Profesor ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Materia que imparte: ");
        String materia = scanner.nextLine();

        Profesor nuevoProfesor = new Profesor(nombre, apellido, edad, genero, materia);
        listaProfesores.add(nuevoProfesor);
        System.out.println("\n Profesor ingresado con éxito. ID asignado: " + nuevoProfesor.getId());
    }

    private static void eliminarAlumno() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("\n No hay alumnos para eliminar.");
            return;
        }

        System.out.print("\nIngrese el ID del Alumno a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getId() == idEliminar) {
                listaAlumnos.remove(i);
                encontrado = true;
                System.out.println("\n🗑 Alumno con ID " + idEliminar + " eliminado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró ningún alumno con ID " + idEliminar + ".");
        }
    }

    private static void eliminarProfesor() {
        if (listaProfesores.isEmpty()) {
            System.out.println("\n No hay profesores para eliminar.");
            return;
        }

        System.out.print("\nIngrese el ID del Profesor a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProfesores.size(); i++) {
            if (listaProfesores.get(i).getId() == idEliminar) {
                listaProfesores.remove(i);
                encontrado = true;
                System.out.println("\n🗑 Profesor con ID " + idEliminar + " eliminado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró ningún profesor con ID " + idEliminar + ".");
        }
    }

    private static void desplegarTodo() {
        System.out.println("\n===========================================");
        System.out.println("      DESPLIEGUE COMPLETO DE PERSONAS");
        System.out.println("===========================================");

        if (listaAlumnos.isEmpty() && listaProfesores.isEmpty()) {
            System.out.println(" Las listas están vacías.");
            return;
        }

        System.out.println("\n*** ALUMNOS REGISTRADOS (" + listaAlumnos.size() + ") ***");
        if (listaAlumnos.isEmpty()) {
            System.out.println("  - No hay alumnos para mostrar.");
        } else {
            for (Alumno a : listaAlumnos) {
                a.mostrarInfo(); // Llama al método específico de Alumno
            }
        }

        System.out.println("\n*** PROFESORES REGISTRADOS (" + listaProfesores.size() + ") ***");
        if (listaProfesores.isEmpty()) {
            System.out.println("  - No hay profesores para mostrar.");
        } else {
            for (Profesor p : listaProfesores) {
                p.mostrarInfo(); // Llama al método específico de Profesor
            }
        }
    }
}