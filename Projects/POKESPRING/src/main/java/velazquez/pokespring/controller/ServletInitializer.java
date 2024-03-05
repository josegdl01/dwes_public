package velazquez.pokespring.controller;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.pokespring.PokespringApplication;

@Controller
@RequestMapping("/servleto/")
public class ServletInitializer extends SpringBootServletInitializer {

    @GetMapping("/hola")
    public String hola(@RequestParam(name = "nombre", required = false, defaultValue = "Default") String cad,
                       Model modelo) {
        modelo.addAttribute("name", cad);

        return "Greeting";
    }

    @GetMapping("/bye")
    public String bye(@RequestParam(name = "nombre2", required = false, defaultValue = "ValorPorDefecto") String cad,
                      Model modelo) {
        modelo.addAttribute("nombre2", cad);
        return "bye";
    }

}
