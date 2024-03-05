package velazquez._1_ejercicioconjunto;

import Model.MatriculaBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet(value="/SeleccionServlet", name = "SeleccionServlet")
public class SeleccionServlet extends HttpServlet {

  static final Logger log = LoggerFactory.getLogger(SeleccionServlet.class);

  public void init() {}

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info("Realizando Get");
    request.getRequestDispatcher("/WEB-INF/View/formulario.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    if (!session.isNew() && (boolean) session.getAttribute("LOGUEADO")) {
      log.info("Realizando Post");
      Enumeration<String> parametros = req.getParameterNames();
      while (parametros.hasMoreElements()) {
        String param = parametros.nextElement();
        log.info(param + ": " + req.getParameter(param));
      }
      String[] seleccion = req.getParameterValues("asignaturas");
      log.info("El valor de Asignatura es: " + Arrays.toString(seleccion));

      MatriculaBean matricula = new MatriculaBean();
      if (req.getParameter("Nombre").isEmpty() && req.getParameter("Nombre").contains("123456789")) {
        log.error("Has introducido un nombre no válido");

        String errorString = "Nombre no válido";
        req.setAttribute("error",errorString);

        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setNombre(req.getParameter("Nombre"));
      }
      if (req.getParameter("Apellidos").isEmpty() && req.getParameter("Apellidos").contains("123456789")) {
        log.error("Has introducido los apellidos no válido");

        String errorString = "Apellido no válido";
        req.setAttribute("error",errorString);

        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setApellidos(req.getParameter("Apellidos"));
      }

      if (req.getParameter("Email").isEmpty()) {
        log.error("Has introducido un email no válido");

        String errorString = "Email no válido";
        req.setAttribute("error",errorString);

        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setEmail(req.getParameter("Email"));
      }
      matricula.setCurso(req.getParameter("Curso"));
      if(seleccion == null){

      } else {
        List<String> asignaturas = Arrays.asList(seleccion);
        matricula.setAsignaturas(asignaturas);
      }
      log.info(matricula.toString());

      session.setAttribute("matriculaBean", matricula);

      resp.sendRedirect(req.getContextPath() + "/MatricularServlet");
    } else {
      log.error("No se ha recibido la sesión adecuada");
      session.invalidate();
      resp.sendRedirect(req.getContextPath());
    }
  }

  public void destroy() {}
}
