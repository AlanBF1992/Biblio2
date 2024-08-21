package cl.praxis.Gestor.controller;

import cl.praxis.Gestor.model.dto.Libro;
import cl.praxis.Gestor.model.dto.Prestamo;
import cl.praxis.Gestor.model.service.BookServiceImpl;
import cl.praxis.Gestor.model.service.PersonaServiceImpl;
import cl.praxis.Gestor.model.service.PrestamoServiceImpl;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class BookController {

    BookServiceImpl bookService;
    PrestamoServiceImpl prestamoService;
    PersonaServiceImpl personaService;

    public BookController(BookServiceImpl bookService, PrestamoServiceImpl prestamoService, PersonaServiceImpl personaService) {
        this.bookService = bookService;
        this.prestamoService = prestamoService;
        this.personaService = personaService;
    }

    @GetMapping("/books")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "booksList";
    }

    @GetMapping(value = "/books", params = "id")
    public String showBookById(@RequestParam("id") int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("prestamos", prestamoService.allPrestamosByBook(id));
        return "bookData";
    }

    @PostMapping(value = "/books", params = "id")
    public String returnBook(@ModelAttribute("idPrestamo") int id, Model model) {
        prestamoService.findById(id).setFechaDevolucion();
        bookService.findById(prestamoService.findById(id).getLibroId()).setAvailable(true);
        return "redirect:/books?id=" + prestamoService.findById(id).getLibroId();
    }

    @GetMapping("books/add")
    public String showAddBook(Model model) {
        return "addBook";
    }

    @PostMapping("books/add")
    public String addBook(@ModelAttribute Libro libro) {
        bookService.create(libro);
        return "redirect:/books";
    }

    @GetMapping("books/loan")
    public String loanPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("personas", personaService.allPersonas());
        return "loan";
    }

    @PostMapping("books/loan")
    public String loan(@ModelAttribute Prestamo prestamo) {
        prestamoService.create(prestamo);
        return "redirect:/books";
    }

    @GetMapping("books/search")
    public String searchBook(Model model) {
        return "searchBook";
    }

    @PostMapping("books/search")
    public String searchBookPost(@RequestParam int searchType, @RequestParam String searchText, Model model) {
        if (searchType == 1) {
            model.addAttribute("books", bookService.findByTitle(searchText));
        } else if (searchType == 2) {
            model.addAttribute("books", bookService.findByAuthor(searchText));
        }

        return "searchBook";
    }

}
