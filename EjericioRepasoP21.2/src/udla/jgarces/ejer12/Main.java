package udla.jgarces.ejer12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<MaterialLectura> listaMaterialLectura = new ArrayList<>();
    private static List<Usuarios> listaUsuarios = new ArrayList<>();
    private static List<Prestamo> listaPrestamo = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🏛️  SISTEMA DE BIBLIOTECA");

        while (true) {
            System.out.println("\n------- MENÚ PRINCIPAL -----");
            System.out.println("1. 📚 Gestión de Materiales");
            System.out.println("2. 👤 Gestión de Usuarios");
            System.out.println("3. 📋 Gestión de Préstamos");
            System.out.println("4. 📊 Reportes");
            System.out.println("5. 🚪 Salir");
            System.out.print("Seleccione opción: ");
            int opcM = scanner.nextInt();
            scanner.nextLine();

            switch (opcM) {
                case 1:
                    menuMateriales();
                    break;
                case 2:
                    menuUsuarios();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 4:
                    menuReportes();
                    break;
                case 5:
                    System.out.println("¡Hasta pronto! 👋");
                    return;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    // ==================== MENÚ MATERIALES ====================
    private static void menuMateriales() {
        while (true) {
            System.out.println("\n--- 📚 GESTIÓN DE MATERIALES ---");
            System.out.println("1. Agregar Material");
            System.out.println("2. Ver Todos los Materiales");
            System.out.println("3. Buscar Material por Título");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    addMaterialLectura();
                    break;
                case 2:
                    mostrarTodosLosMateriales();
                    break;
                case 3:
                    buscarMaterialPorTitulo();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    private static void addMaterialLectura() {
        System.out.println("\n----- 📝 Ingreso de Material --------");

        System.out.println("Seleccione tipo de material:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Tesis");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año: ");
        int año = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Estado:");
        System.out.println("1. DISPONIBLE");
        System.out.println("2. PRESTADO");
        System.out.print("Opción: ");
        int opcionEstado = scanner.nextInt();
        scanner.nextLine();

        Estado estado = (opcionEstado == 1) ? Estado.DISPONIBLE : Estado.PRESTADO;

        switch (tipo) {
            case 1:
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                Libro nuevoLibro = new Libro(titulo, autor, año, estado, isbn);
                listaMaterialLectura.add(nuevoLibro);
                System.out.println("✅ Libro agregado con éxito");
                break;

            case 2:
                System.out.print("Número de edición: ");
                int numEdicion = scanner.nextInt();
                scanner.nextLine();
                Revista nuevaRevista = new Revista(titulo, autor, año, estado, numEdicion);
                listaMaterialLectura.add(nuevaRevista);
                System.out.println("✅ Revista agregada con éxito");
                break;

            case 3:
                System.out.print("Universidad: ");
                String universidad = scanner.nextLine();
                Tesis nuevaTesis = new Tesis(titulo, autor, año, estado, universidad);
                listaMaterialLectura.add(nuevaTesis);
                System.out.println("✅ Tesis agregada con éxito");
                break;

            default:
                System.out.println("❌ Tipo de material no válido");
        }
    }

    private static void mostrarTodosLosMateriales() {
        if (listaMaterialLectura.isEmpty()) {
            System.out.println("📭 No hay materiales registrados.");
            return;
        }

        System.out.println("\n=== TODOS LOS MATERIALES ===");
        for (int i = 0; i < listaMaterialLectura.size(); i++) {
            MaterialLectura material = listaMaterialLectura.get(i);
            System.out.println("📖 Material #" + (i + 1));
            material.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    private static void buscarMaterialPorTitulo() {
        System.out.print("🔍 Ingrese título a buscar: ");
        String tituloBuscado = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (MaterialLectura material : listaMaterialLectura) {
            if (material.getTitulo().toLowerCase().contains(tituloBuscado)) {
                material.mostrarInfo();
                System.out.println("---");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontraron materiales con ese título.");
        }
    }

    // ==================== MENÚ USUARIOS ====================
    private static void menuUsuarios() {
        while (true) {
            System.out.println("\n--- 👤 GESTIÓN DE USUARIOS ---");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Ver Todos los Usuarios");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    addUsuarios();
                    break;
                case 2:
                    mostrarTodosLosUsuarios();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    private static void addUsuarios() {
        System.out.println("\n----- 👤 Ingreso de Usuarios --------");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("Tipo:");
        System.out.println("1. ESTUDIANTE");
        System.out.println("2. PROFESOR");
        System.out.print("Opción: ");
        int opcionTipo = scanner.nextInt();
        scanner.nextLine();

        TIpousuario tipo = (opcionTipo == 1) ? TIpousuario.ESTUDIANTE : TIpousuario.PROFESOR;

        Usuarios nuevoUsuario = new Usuarios(nombre, id, email, tipo);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("✅ Usuario agregado con éxito");
    }

    private static void mostrarTodosLosUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("👥 No hay usuarios registrados.");
            return;
        }

        System.out.println("\n=== TODOS LOS USUARIOS ===");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuarios usuario = listaUsuarios.get(i);
            System.out.println("👤 Usuario #" + (i + 1));
            usuario.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    // ==================== MENÚ PRÉSTAMOS ====================
    private static void menuPrestamos() {
        while (true) {
            System.out.println("\n--- 📋 GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Realizar Préstamo");
            System.out.println("2. Ver Todos los Préstamos");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    realizarPrestamo();
                    break;
                case 2:
                    mostrarTodosLosPrestamos();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    private static void realizarPrestamo() {
        if (listaMaterialLectura.isEmpty() || listaUsuarios.isEmpty()) {
            System.out.println("❌ Debe haber al menos un material y un usuario registrado.");
            return;
        }

        System.out.println("\n----- 📝 Realizar Préstamo --------");

        // Mostrar materiales disponibles
        System.out.println("📚 Materiales disponibles:");
        List<MaterialLectura> materialesDisponibles = new ArrayList<>();
        for (MaterialLectura material : listaMaterialLectura) {
            if (material.getEstado() == Estado.DISPONIBLE) {
                materialesDisponibles.add(material);
                System.out.println((materialesDisponibles.size()) + ". " + material.getTitulo());
            }
        }

        if (materialesDisponibles.isEmpty()) {
            System.out.println("❌ No hay materiales disponibles para préstamo.");
            return;
        }

        System.out.print("Seleccione material: ");
        int idxMaterial = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idxMaterial < 0 || idxMaterial >= materialesDisponibles.size()) {
            System.out.println("❌ Selección no válida.");
            return;
        }

        // Mostrar usuarios
        System.out.println("\n👤 Usuarios:");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
        }

        System.out.print("Seleccione usuario: ");
        int idxUsuario = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idxUsuario < 0 || idxUsuario >= listaUsuarios.size()) {
            System.out.println("❌ Selección no válida.");
            return;
        }

        MaterialLectura material = materialesDisponibles.get(idxMaterial);
        Usuarios usuario = listaUsuarios.get(idxUsuario);

        // Cambiar estado del material
        material.estado = Estado.PRESTADO;

        // Crear préstamo
        Prestamo nuevoPrestamo = new Prestamo(material, usuario);
        listaPrestamo.add(nuevoPrestamo);

        System.out.println("✅ Préstamo realizado con éxito");
        nuevoPrestamo.mostrarInfo();
    }

    private static void mostrarTodosLosPrestamos() {
        if (listaPrestamo.isEmpty()) {
            System.out.println("📭 No hay préstamos registrados.");
            return;
        }

        System.out.println("\n=== TODOS LOS PRÉSTAMOS ===");
        for (int i = 0; i < listaPrestamo.size(); i++) {
            Prestamo prestamo = listaPrestamo.get(i);
            System.out.println("📋 Préstamo #" + (i + 1));
            prestamo.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    // ==================== MENÚ REPORTES ====================
    private static void menuReportes() {
        while (true) {
            System.out.println("\n--- 📊 REPORTES ---");
            System.out.println("1. Materiales por Tipo");
            System.out.println("2. Materiales Prestados");
            System.out.println("3. Materiales Disponibles");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    reporteMaterialesPorTipo();
                    break;
                case 2:
                    reporteMaterialesPrestados();
                    break;
                case 3:
                    reporteMaterialesDisponibles();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("❌ Opción no válida");
            }
        }
    }

    private static void reporteMaterialesPorTipo() {
        int libros = 0, revistas = 0, tesis = 0;

        for (MaterialLectura material : listaMaterialLectura) {
            if (material instanceof Libro) libros++;
            else if (material instanceof Revista) revistas++;
            else if (material instanceof Tesis) tesis++;
        }

        System.out.println("\n=== 📊 MATERIALES POR TIPO ===");
        System.out.println("📚 Libros: " + libros);
        System.out.println("📰 Revistas: " + revistas);
        System.out.println("🎓 Tesis: " + tesis);
        System.out.println("📦 Total: " + listaMaterialLectura.size());
    }

    private static void reporteMaterialesPrestados() {
        System.out.println("\n=== 📊 MATERIALES PRESTADOS ===");
        boolean hayPrestados = false;

        for (MaterialLectura material : listaMaterialLectura) {
            if (material.getEstado() == Estado.PRESTADO) {
                material.mostrarInfo();
                System.out.println("---");
                hayPrestados = true;
            }
        }

        if (!hayPrestados) {
            System.out.println("✅ Todos los materiales están disponibles.");
        }
    }

    private static void reporteMaterialesDisponibles() {
        System.out.println("\n=== 📊 MATERIALES DISPONIBLES ===");
        boolean hayDisponibles = false;

        for (MaterialLectura material : listaMaterialLectura) {
            if (material.getEstado() == Estado.DISPONIBLE) {
                material.mostrarInfo();
                System.out.println("---");
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("❌ No hay materiales disponibles.");
        }
    }
}