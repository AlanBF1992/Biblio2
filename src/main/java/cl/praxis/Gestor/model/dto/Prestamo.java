package cl.praxis.Gestor.model.dto;

import cl.praxis.Gestor.model.service.PersonaServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private int id;
    private int libroId;
    private int personaId;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Prestamo(int libroId, int personaId, String fechaPrestamo) {
        this.libroId = libroId;
        this.personaId = personaId;
        this.fechaPrestamo = LocalDateTime.parse(fechaPrestamo, formato);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public Persona getPersona() {
        return new PersonaServiceImpl().findById(personaId);
    }

    public LocalDateTime getFecha() {
        return fechaPrestamo;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaPrestamo = fecha;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion() {
        this.fechaDevolucion = LocalDateTime.now();
    }
}
