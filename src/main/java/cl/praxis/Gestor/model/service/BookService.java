package cl.praxis.Gestor.model.service;

import cl.praxis.Gestor.model.dto.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Libro> findAll();
    Libro findById(int id);
    Libro findByTitle(String title);
    Libro findByAuthor(String author);
    boolean create(Libro libro);
    boolean update(Libro libro);
    boolean delete(int id);
}
