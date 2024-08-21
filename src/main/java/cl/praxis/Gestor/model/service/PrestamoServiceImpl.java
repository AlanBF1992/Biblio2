package cl.praxis.Gestor.model.service;

import cl.praxis.Gestor.model.dto.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    private final List<Prestamo> prestamos;
    BookServiceImpl bookService;

    @Autowired
    public PrestamoServiceImpl(BookServiceImpl bookService) {
        this.bookService = bookService;
        prestamos = new ArrayList<Prestamo>();
    }

    @Override
    public List<Prestamo> allPrestamos() {
        return prestamos;
    }

    @Override
    public List<Prestamo> allPrestamosByBook(int id){
        return prestamos.stream().filter(p -> p.getLibroId() == id).toList();
    }

    @Override
    public Prestamo findById(int id) {
        return prestamos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean create(Prestamo prestamo) {
        if (bookService.findById(prestamo.getLibroId()).isAvailable()) {
            prestamo.setId(prestamos.stream().map(Prestamo::getId).max(Integer::compareTo).orElse(0) + 1);
            prestamos.add(prestamo);
            bookService.findById(prestamo.getLibroId()).setAvailable(false);
            return true;
        }
        System.out.println("No se pudo agregar para el libro " + prestamo.getLibroId());
        System.out.println("Su available es: " + bookService.findById(prestamo.getLibroId()).isAvailable());
        return false;
    }

    @Override
    public boolean update(Prestamo prestamo) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
