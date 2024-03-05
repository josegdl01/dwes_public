package velazquez.reservasjgd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/ServletConfirmar")
public class ServletConfirmar extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(ServletInicio.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Iniciando GET");
        HttpSession session = req.getSession();
        //Comprobamos si la sesión es nueva y los atributos no son nulos
        if(session.isNew() || session.getAttribute("nombreUsuario") == null || session.getAttribute("inicioSesion") == null){
            log.error("No se ha iniciado sesión");
            resp.sendRedirect(req.getContextPath());
        } else {
            //Mandamos la sesión al jsp de matricular para que este pinte la reserva
            req.getRequestDispatcher("/WEB-INF/View/datosReserva.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
