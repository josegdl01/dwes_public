package velazquez.jgd_ejerciciotrimestral;

import java.io.*;
import java.util.ArrayList;

import Dao.EmpleadoDAO;
import Dao.EmpleadoDAOImpl;
import Models.EmpleadoBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmpleadosServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(EmpleadosServlet.class);

    public void init() {}

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
        ArrayList<EmpleadoBean> empleados = empleadoDAO.getAllEmpleados();
        session.setAttribute("empleados", empleados);
        log.info(empleados.toString());
        req.getRequestDispatcher("/WEB-INF/Views/empleados.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    public void destroy() {
    }
}
