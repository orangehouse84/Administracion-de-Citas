/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orangehouse.citasconsultorio;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivo {

    public static void guardarDoctores(List<Doctor> doctores, String nombreArchivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Doctor doctor : doctores) {
                escritor.write(doctor.getId() + "," + doctor.getNombre() + "," + doctor.getEspecialidad());
                escritor.newLine();
            }
        }
    }

    public static List<Doctor> cargarDoctores(String nombreArchivo) throws IOException {
        List<Doctor> doctores = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                doctores.add(new Doctor(Integer.parseInt(datos[0]), datos[1], datos[2]));
            }
        }
        return doctores;
    }

    public static void guardarPacientes(List<Paciente> pacientes, String nombreArchivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Paciente paciente : pacientes) {
                escritor.write(paciente.getId() + "," + paciente.getNombre());
                escritor.newLine();
            }
        }
    }

    public static List<Paciente> cargarPacientes(String nombreArchivo) throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                pacientes.add(new Paciente(Integer.parseInt(datos[0]), datos[1]));
            }
        }
        return pacientes;
    }

    public static void guardarCitas(List<Cita> citas, String nombreArchivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) { // Append mode
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (Cita cita : citas) {
                String linea = String.format("%d,%s,%s,%d,%d%n",
                        cita.getId(), cita.getFechaHora().format(formatter), cita.getMotivo(), cita.getIdDoctor(), cita.getIdPaciente());
                escritor.write(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar las citas en el archivo: " + e.getMessage());
            // Consider re-throwing the exception or handling it differently
            // throw e; // Example of re-throwing the exception
        }
    }

    public static List<Cita> cargarCitas(String nombreArchivo) throws IOException {
    List<Cita> citas = new ArrayList<>();
    try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
        // ... your code for reading the file ...
    } catch (FileNotFoundException e) {
        System.err.println("Archivo de citas no encontrado: " + nombreArchivo);
        // Create a new empty file:
        File nuevoArchivo = new File(nombreArchivo);
        if (nuevoArchivo.createNewFile()) {
            System.out.println("Se ha creado un nuevo archivo de citas: " + nombreArchivo);
        } else {
            System.err.println("No se pudo crear el archivo de citas.");
        }
    } catch (IOException e) {
        // ... other exception handling ...
    }
    return citas;
    }
}

 

   
  
   

