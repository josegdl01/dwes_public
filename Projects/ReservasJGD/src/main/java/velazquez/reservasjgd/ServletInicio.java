package velazquez.reservasjgd;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/ServletInicio")
public class ServletInicio extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(ServletInicio.class);

    public void init() {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        //Pasamos los datos al formulario de entrada
        req.getRequestDispatcher("/WEB-INF/View/formularioEntrada.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        Enumeration<String> parametros = req.getParameterNames();

        while (parametros.hasMoreElements()) {
            String param = parametros.nextElement();
            log.info(param + ": " + req.getParameter(param));
        }

        //Comprobamos que el nombre de usuario esté vacío
        if (req.getParameter("usuario").isEmpty()) {
            log.error("Nombre de usuario incorrecto");
            resp.sendRedirect(req.getContextPath());
            return;
        }

        //Comprobamos que la contraseña cumpla con los requerimientos de seguridad
        String regEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        if (req.getParameter("password").isEmpty() || !(req.getParameter("password").matches(regEx))) {
            log.error("Contraseña incorrecta");
            resp.sendRedirect(req.getContextPath());
            return;
        } else {
            //Seguidamente, comprobamos que coincida con su confirmación
            if (req.getParameter("passwordConfirm").isEmpty() || !(req.getParameter("password").equals(req.getParameter("passwordConfirm")))) {
                log.error("Contraseña y confirmación diferentes");
                resp.sendRedirect(req.getContextPath());
                return;
            }
        }

        //Comprobamos el email
        if (req.getParameter("email").isEmpty()) {
            log.error("Email incorrecto");
            resp.sendRedirect(req.getContextPath());
            return;
        }
        //Creamos el atributo de inicio de sesión
        String momentoInicio = String.valueOf(LocalDateTime.now().getHour() + " : " + LocalDateTime.now().getMinute() + " del " + LocalDateTime.now().getDayOfMonth() + " de " + LocalDateTime.now().getMonth());
        //Creamos la sesión y le pasamos los atributos requeridos
        HttpSession session = req.getSession();
        session.setAttribute("nombreUsuario", req.getParameter("usuario"));
        session.setAttribute("inicioSesion", momentoInicio);

        log.info("SESIÓN INICIADA");
        resp.sendRedirect(req.getContextPath() + "/ServletReservar");

    }

    public void destroy() {
    }
}