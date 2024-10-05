/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orangehouse.citasconsultorio;

/**
 *
 * @author oscar
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.DateTimeException; // Import DateTimeException

public class InterfazGrafica {

    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Cita> citas;

    private Scanner scanner;

public InterfazGrafica() throws IOException {
    doctores = new ArrayList<>();
    pacientes = new ArrayList<>();
    citas = new ArrayList<>();

    try {
        citas = GestorArchivo.cargarCitas("citas.csv"); 
    } catch (IOException e) {
        mostrarError("Error al cargar las citas: " + e.getMessage());
        citas = new ArrayList<>(); 
    }

    scanner = new Scanner(System.in);

    // Iniciar la interfaz de línea de comandos AFTER initializing the scanner
    iniciarInterfaz(); 
}

    private void iniciarInterfaz() {
        System.out.println("Administracion de Citas");

        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    guardarDoctor();
                    break;
                case 2:
                    try {
                        guardarPaciente();
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    try {
                        guardarCita();
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción invalida. Intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Dar de alta doctor");
        System.out.println("2. Dar de alta paciente");
        System.out.println("3. Crear cita");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    private int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada invalida. Ingrese un numero.");
            scanner.next(); // Consumir la entrada inválida
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea pendiente
        return opcion;
    }

    private void guardarDoctor() {
        try {
            System.out.print("ID del doctor: ");
            int id = obtenerOpcion();

            System.out.print("Nombre del doctor: ");
            String nombre = scanner.nextLine(); 

            System.out.print("Especialidad del doctor: ");
            String especialidad = scanner.nextLine();

            // Validar que el ID sea único
            for (Doctor doctor : doctores) {
                if (doctor.getId() == id) {
                    mostrarError("Ya existe un doctor con ese ID.");
                    return;
                }
            }

            Doctor nuevoDoctor = new Doctor(id, nombre, especialidad);
            doctores.add(nuevoDoctor);
            GestorArchivo.guardarDoctores(doctores, "doctores.csv");

            mostrarMensaje("Doctor guardado correctamente.");
        } catch (NumberFormatException e) {
            mostrarError("ID invalido. Debe ser un numero entero.");
        } catch (IOException e) {
            mostrarError("Error al guardar doctor: " + e.getMessage());
        }
    }

    private void guardarPaciente() throws IOException {
        try {
            System.out.print("ID del paciente: ");
            int id = obtenerOpcion();

            System.out.print("Nombre del paciente: ");
            String nombre = scanner.nextLine(); 

            // Validar que el ID sea único
            for (Paciente paciente : pacientes) {
                if (paciente.getId() == id) {
                    mostrarError("Ya existe un paciente con ese ID.");
                    return;
                }
            }

            Paciente nuevoPaciente = new Paciente(id, nombre);
            pacientes.add(nuevoPaciente);
            GestorArchivo.guardarPacientes(pacientes, "pacientes.csv");

            mostrarMensaje("Paciente guardado correctamente.");
        } catch (NumberFormatException e) {
            mostrarError("ID invalido. Debe ser un numero entero.");
        } catch (IOException e) {
            mostrarError("Error al guardar paciente: " + e.getMessage());
        }
    }

private void guardarCita() throws IOException {
    try {
        System.out.print("ID de la cita: ");
        int id = obtenerOpcion();

        System.out.print("Anio de la cita: ");
        int anio = obtenerOpcion(); // Declare 'anio' here

        System.out.print("Mes de la cita: ");
        int mes = obtenerOpcion();  // Declare 'mes' here

        System.out.print("Dia de la cita: ");
        int dia = obtenerOpcion();  // Declare 'dia' here

        System.out.print("Hora de la cita (0-23): ");
        int hora = obtenerOpcion();
        while (hora < 0 || hora > 23) {
            System.out.println("Hora invalida. Ingrese una hora entre 0 y 23: ");
            hora = obtenerOpcion();
        }

        System.out.print("Minuto de la cita (0-59): ");
        int minuto = obtenerOpcion();
        while (minuto < 0 || minuto > 59) {
            System.out.println("Minuto invalido. Ingrese un minuto entre 0 y 59: ");
            minuto = obtenerOpcion();
        }

        LocalDateTime fechaHora = LocalDateTime.of(anio, mes, dia, hora, minuto);

        // ... rest of the code ...

    } catch (DateTimeException e) {  // Now you can catch DateTimeException
        mostrarError("Fecha u hora invalidas: " + e.getMessage());
    } catch (NumberFormatException e) {
        mostrarError("ID, fecha u hora invalidos. Deben ser numeros enteros.");
    }
}

    private void mostrarError(String mensaje) {
        System.err.println("Error: " + mensaje);
    }

    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String args[]) {
        try {
            new InterfazGrafica();
        } catch (IOException ex) {
            Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

       
    
    
        
        
   
