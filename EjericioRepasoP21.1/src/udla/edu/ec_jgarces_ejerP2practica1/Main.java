package udla.edu.ec_jgarces_ejerP2practica1;
import udla.edu.ec_jgarces_ejerP2practica1.services.SistemaDeGestionHospital;

public class Main {
    public static void main(String[] args) {
        SistemaDeGestionHospital sistema = new SistemaDeGestionHospital();
        System.out.println("=== BIENVENIDO AL SISTEMA DE GESTIÓN HOSPITALARIA ===");
        System.out.println("Nota: El sistema inicia vacío. Debe registrar personal médico y pacientes primero.");
        sistema.mostrarMenu();
    }
}