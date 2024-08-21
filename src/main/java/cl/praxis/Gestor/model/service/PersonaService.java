package cl.praxis.Gestor.model.service;

import cl.praxis.Gestor.model.dto.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    List<Persona> allPersonas();
    Persona findById(int id);
    boolean create(Persona persona);
    boolean update(Persona persona);
    boolean delete(int id);
}
