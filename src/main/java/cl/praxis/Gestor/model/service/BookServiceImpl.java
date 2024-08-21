package cl.praxis.Gestor.model.service;

import cl.praxis.Gestor.model.dto.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final List<Libro> books;

    public BookServiceImpl() {
        books = new ArrayList<>();
        books.add(new Libro(1,"Libro 1", "Autor 1", "1234", 1999));
        books.add(new Libro(2,"Libro 2", "Autor 2", "1235", 1998));
        books.add(new Libro(3,"Libro 3", "Autor 2", "2235", 2001));
        books.add(new Libro(4,"Libro 4", "Autor 1", "4235", 2007));
    }

    @Override
    public List<Libro> findAll() {
        return books;
    }

    @Override
    public Libro findById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Libro findByTitle(String title) {
        return books.stream().filter(b -> b.getTitulo().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    @Override
    public Libro findByAuthor(String author) {
        return books.stream().filter(b -> b.getAutor().equals(author)).findFirst().orElse(null);
    }

    @Override
    public boolean create(Libro libro) {
        try {
            books.add(libro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Libro libro) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
