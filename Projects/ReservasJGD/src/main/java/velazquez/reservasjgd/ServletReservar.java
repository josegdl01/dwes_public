package velazquez.reservasjgd;

import Model.ReservaBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/ServletReservar")
public class ServletReservar extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(ServletReservar.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        if (session.isNew() || session.getAttribute("nombreUsuario") == null || session.getAttribute("inicioSesion") == null) {
            log.error("No se ha iniciado sesión");
            resp.sendRedirect(req.getContextPath());
        } else {
            req.getRequestDispatcher("/WEB-INF/View/formularioReserva.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        HttpSession session = req.getSession();
        if (session.isNew() || session.getAttribute("nombreUsuario") == null || session.getAttribute("inicioSesion") == null) {
            log.error("No se ha iniciado sesión");
            resp.sendRedirect(req.getContextPath());
        } else {
            ReservaBean reservaBean = new ReservaBean();

            //Comprobamos si el inicio de reserva está vacío
            if (!(req.getParameter("inicioReserva").equalsIgnoreCase("")) ) {
                reservaBean.setFechaInicio(req.getParameter("inicioReserva"));
            } else {
                log.error("Introduzca una fecha de inicio");
                resp.sendRedirect(req.getContextPath() + "/ServletReservar");
                return;
            }

            //Comprobamos si el fin de reserva está vacío
            if (!(req.getParameter("finReserva").equalsIgnoreCase(""))) {
                reservaBean.setFechaFin(req.getParameter("finReserva"));
            } else {
                log.error("Introduzca una fecha de salida");
                resp.sendRedirect(req.getContextPath() + "/ServletReservar");
                return;
            }

            //Comprobamos si el número de personas está vacío o es igual a 0
            if (!(req.getParameter("numPersonas").equalsIgnoreCase("")) && !(req.getParameter("numPersonas").equalsIgnoreCase("0"))) {
                reservaBean.setNumPersonas(Integer.parseInt(req.getParameter("numPersonas")));
            } else {
                log.error("Introduzca un número de personas");
                resp.sendRedirect(req.getContextPath() + "/ServletReservar");
                return;
            }
            //Creamos un ArrayList que reciba los parámetros de los servicio en caso de que existan, si no, quedará vacío.
            Enumeration<String> parametros = req.getParameterNames();
            while (parametros.hasMoreElements()){
                String servicio = parametros.nextElement();
                if (servicio.equalsIgnoreCase("wifi") ||
                        servicio.equalsIgnoreCase("toallas")
                        || servicio.equalsIgnoreCase("desayuno")
                        || servicio.equalsIgnoreCase("limpieza")
                        || servicio.equalsIgnoreCase("ruta guiada")
                        || servicio.equalsIgnoreCase("sauna")) {
                    reservaBean.getServicios().add(servicio);
                }
            }

            //Creamos el atributo con los datos de la reserva y lo añadimos a la sesión
            session.setAttribute("reservaBean", reservaBean);
            log.info("RESERVA CONFIRMADA");
            log.info(reservaBean.toString());
            resp.sendRedirect(req.getContextPath() + "/ServletConfirmar");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
