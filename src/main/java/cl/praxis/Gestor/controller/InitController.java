package cl.praxis.Gestor.controller;

import cl.praxis.Gestor.model.dto.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InitController {

    @GetMapping("/")
    public String init() {
        return "index";
    }
}
