package cl.praxis.Gestor.controller;

import cl.praxis.Gestor.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InitController {

    @GetMapping("/{name}/{lastName}/{age}")
    public String init(@PathVariable String name, @PathVariable String lastName, @PathVariable int age) {
        //Aquí iria la revisión de errores
        Persona p = new Persona(age, name, lastName);
        System.out.println(p);
        return "index";
    }
}
