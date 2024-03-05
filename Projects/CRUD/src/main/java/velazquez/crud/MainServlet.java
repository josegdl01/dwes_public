package velazquez.crud;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    final static Logger log = LoggerFactory.getLogger(MainServlet.class);

    public void init() {}

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/View/formularioEntrada.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("Realizando POST");
        if(req.getParameter("name").equals("root") && req.getParameter("pswd").equals("XXXXX")){
            HttpSession session = req.getSession();
            session.setAttribute("sesionCorrecta", true);
            resp.sendRedirect(req.getContextPath() + "/MenuServlet");
        } else {
            log.error("No se ha iniciado sesión correctamente.");
            resp.sendRedirect(req.getContextPath());
        }
    }

    public void destroy() {}
}