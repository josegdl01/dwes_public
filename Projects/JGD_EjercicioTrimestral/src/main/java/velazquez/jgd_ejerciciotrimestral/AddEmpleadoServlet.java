package velazquez.jgd_ejerciciotrimestral;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;

import Dao.EmpleadoDAO;
import Dao.EmpleadoDAOImpl;
import Dao.OficinaDAO;
import Dao.OficinaDAOImpl;
import Models.EmpleadoBean;
import Models.OficinaBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddEmpleadoServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(AddEmpleadoServlet.class);

    public void init() {}

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        OficinaDAO oficinaDAO = new OficinaDAOImpl();
        ArrayList<OficinaBean> oficinas = oficinaDAO.getAllOficinas();
        session.setAttribute("oficinas", oficinas);
        log.info(oficinas.toString());

        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
        ArrayList<EmpleadoBean> jefes = empleadoDAO.getAllJefes();
        session.setAttribute("jefes", jefes);
        log.info(jefes.toString());

        req.getRequestDispatcher("/WEB-INF/Views/addEmpleado.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        HttpSession session = req.getSession();
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
        int empId = Integer.valueOf(req.getParameter("empId"));
        String empNom = req.getParameter("empNombre");
        String empAp = req.getParameter("empApellidos");
        String empExt = req.getParameter("empExt");
        String empEmail = req.getParameter("empEmail");
        String empPuesto = req.getParameter("empPuesto");
        String empOficina = req.getParameter("empOficina");
        String empJefe = req.getParameter("empJefe");
        EmpleadoBean emp = new EmpleadoBean(String.valueOf(empId),empAp,empNom,empExt,empEmail,empPuesto,empOficina, empJefe);
        String error = null;
        if(empleadoDAO.getEmpleado(empId) != null){
            error = "Ese ID ya está en uso";
            log.info(error);
            session.setAttribute("error", error);
            resp.sendRedirect(req.getContextPath() + "/Admin/AddEmpleado");
            return;
        } else {
            if(empleadoDAO.insertEmpleado(emp)){
                resp.sendRedirect(req.getContextPath() + "/Admin/Empleados");
            } else {
                log.error("Ha habido un error añadiendo un empleado");
            }



        }
    }

    public void destroy() {
    }
}
