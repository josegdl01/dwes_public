package velazquez.garciadelemus_jose_jstl;

import Dao.UsuarioDAO;
import Dao.UsuarioDAOImpl;
import Models.UsuarioBean;
import Utilidades.PassGen;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class RegistroServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(RegistroServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando Get");
        req.getRequestDispatcher("/WEB-INF/Views/formularioRegistro.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        log.info("Realizando Post");
        String name = req.getParameter("userReg");
        String firstName = req.getParameter("firstReg");
        String lastName = req.getParameter("lastReg");
        String email = req.getParameter("emailReg");
        String password = req.getParameter("pswdReg");
        if(!name.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            if(usuarioDAO.getUsuario(req.getParameter("user")) == null){
                password = PassGen.hashPassword(password);
                UsuarioBean usuarioBean = new UsuarioBean(name,firstName,lastName,password,email,"user");
                if(usuarioDAO.addUsuario(usuarioBean)){
                    log.info("Usuario añadido con éxito");
                    log.info(name +"\n"+ email +"\n"+ password+"\n"+usuarioDAO.getUsuario(name).getRole());
                } else {
                    log.error("Error al añadir un usuario");
                    log.info(name +"\n"+ firstName+"\n"+ lastName+"\n"+ password +"\n"+ email);
                }
            } else {
                log.error("Este usuario ya existe");
            }
        } else {
            log.error("Se deben rellenar todos los campos");
        }
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
