package velazquez.pokespring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import velazquez.pokespring.dataTransferObjects.Pokemon;

@Controller
@RequestMapping("/forms")
public class PokeFormServlet{

    private final Logger log = LoggerFactory.getLogger(PokeFormServlet.class);

    @GetMapping("/formPokemon")
    public String formPokemonGet(Model model){

        Pokemon poke = new Pokemon();
        model.addAttribute("poke", poke);

        return "forms/formPokemon";
    }

    @PostMapping("/formPokemon")
    public String formPokemonPost(@ModelAttribute Pokemon poke, Model model){
        log.info("Mi gente, tamo en el post");
        model.addAttribute("poke", poke);

        return "forms/formPokemon";
    }
}
