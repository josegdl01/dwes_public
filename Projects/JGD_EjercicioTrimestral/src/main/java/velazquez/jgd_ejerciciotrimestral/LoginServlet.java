package velazquez.jgd_ejerciciotrimestral;

import java.io.*;
import java.util.ArrayList;

import Dao.ProductoDAO;
import Dao.ProductoDAOImpl;
import Dao.UsuarioDAO;
import Dao.UsuarioDAOImpl;
import Models.UsuarioBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(LoginServlet.class);

    public void init() {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        UsuarioDAO userDao = new UsuarioDAOImpl();
        UsuarioBean usuarioBean = userDao.getUsuario(req.getParameter("email"));

        ProductoDAO productoDAO = new ProductoDAOImpl();
        if (usuarioBean == null) {
            log.error("Este usuario no se encuentra en la base de datos");
            resp.sendRedirect(req.getContextPath());
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("usuario", usuarioBean);
            log.info("Sesión iniciada como " + usuarioBean.getRole());
            resp.sendRedirect(req.getContextPath() + "/Home");
        }
    }

    public void destroy() {
    }
}