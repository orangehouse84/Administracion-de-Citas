/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orangehouse.citasconsultorio;

/**
 *
 * @author oscar
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cita {
    private int id;
    private LocalDateTime fechaHora;
    private String motivo;
    private int idDoctor; // ID del doctor que atenderá la cita
    private int idPaciente; // ID del paciente que tiene la cita

    public Cita(int id, LocalDateTime fechaHora, String motivo, int idDoctor, int idPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Cita{" +
                "id=" + id +
                ", fechaHora=" + fechaHora.format(formatter) +
                ", motivo='" + motivo + '\'' +
                ", idDoctor=" + idDoctor +
                ", idPaciente=" + idPaciente +
                '}';
    }
}    

