package velazquez.jgd_ejerciciotrimestral;

import java.io.*;
import java.util.ArrayList;

import Dao.EmpleadoDAO;
import Dao.EmpleadoDAOImpl;
import Dao.ProductoDAO;
import Dao.ProductoDAOImpl;
import Models.EmpleadoBean;
import Models.UsuarioBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InicioServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(InicioServlet.class);

    public void init() {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        ProductoDAO productoDAO = new ProductoDAOImpl();
        ArrayList<String> categorias = productoDAO.getCategorias();
        session.setAttribute("categorias", categorias);
        log.info(categorias.toString());
        req.getRequestDispatcher("/WEB-INF/Views/inicio.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void destroy() {
    }
}
