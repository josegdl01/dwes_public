package velazquez.entregablefinaljgd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velazquez.entregablefinaljgd.models.Usuarios;
import velazquez.entregablefinaljgd.services.UsuarioServiceImpl;

import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/usuarios")
    public String usuarios(Model model){

        List<Usuarios> usuarios = usuarioService.getAllUsuarios();

        model.addAttribute("usuarios", usuarios);

        return "usuariosList";
    }

    @GetMapping("/usuarios/borrar")
    public String deleteUsuario(@RequestParam(required = false, name = "id") String id){

        Usuarios usuario = usuarioService.getUsuarioById(Integer.parseInt(id));

        if(usuario != null){
            usuarioService.deleteUsuario(usuario);
        }

        return "redirect:/usuarios";
    }
}
