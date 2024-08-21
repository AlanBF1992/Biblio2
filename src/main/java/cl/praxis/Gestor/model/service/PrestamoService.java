package cl.praxis.Gestor.model.service;

import cl.praxis.Gestor.model.dto.Prestamo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrestamoService {
    List<Prestamo> allPrestamos();
    List<Prestamo> allPrestamosByBook(int id);
    Prestamo findById(int id);
    boolean create(Prestamo prestamo);
    boolean update(Prestamo prestamo);
    boolean delete(int id);
}
