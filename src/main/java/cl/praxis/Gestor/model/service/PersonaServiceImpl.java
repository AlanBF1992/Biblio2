package cl.praxis.Gestor.model.service;

import cl.praxis.Gestor.model.dto.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final List<Persona> personas;

    public PersonaServiceImpl () {
        personas = new ArrayList<Persona>();
        personas.add(new Persona(1,14, "Luis", "Salgado"));
        personas.add(new Persona(2, 21, "Eduardo", "Smith"));
        personas.add(new Persona(3, 45, "Marcela", "Paz"));
    }

    @Override
    public List<Persona> allPersonas() {
        return personas;
    }

    @Override
    public Persona findById(int id) {
        return personas.stream().filter(persona -> persona.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean create(Persona persona) {
        return false;
    }

    @Override
    public boolean update(Persona persona) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
