package velazquez.entregablefinaljgd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.entregablefinaljgd.dto.UserDTO;
import velazquez.entregablefinaljgd.models.Usuarios;
import velazquez.entregablefinaljgd.services.UsuarioServiceImpl;

@Controller
public class RegisterController {

    Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/register")
    public String registerGet(Model model){
        log.info("GET DEL REGISTRO DE USUARIOS");

        UserDTO user = new UserDTO();
        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute(name = "user") UserDTO user){

        log.info("POST DEL REGISTRO DE USUARIOS");
        Usuarios userIns = new Usuarios();

        userIns.setNombre(user.getNombre());
        userIns.setApellidos(user.getApellidos());
        userIns.setEmail(user.getEmail());
        userIns.setUsuario(user.getUsuario());
        userIns.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userIns.setActivo(true);
        userIns.setRole("ROLE_USER");

        userIns = usuarioService.addUsuario(userIns);

        if(userIns == null){
            return "redirect:/register";
        }

        return "redirect:/login";
    }
}
