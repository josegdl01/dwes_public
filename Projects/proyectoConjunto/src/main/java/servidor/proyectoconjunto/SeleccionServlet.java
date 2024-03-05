package servidor.proyectoconjunto;

import Modelos.Matricula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {

  static final Logger logger = LoggerFactory.getLogger(SeleccionServlet.class);

  /**
   * @throws ServletException
   */
  @Override
  public void init() throws ServletException {
    super.init();
  }

  /**
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Realizando GET");
    HttpSession session = req.getSession();
    if (!session.isNew()
            && (boolean) session.getAttribute("LOGUEADO")
            && session.getAttribute("LOGUEADO") != null) {
      req.getRequestDispatcher("/WEB-INF/Views/formulario.jsp").forward(req, resp);
      logger.info("Sesión valida");
    } else {
      logger.error("No se ha recibido una sesión valida.");
      session.invalidate();
    }

  }

  /**
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    if (!session.isNew()
        && (boolean) session.getAttribute("LOGUEADO")) {
      logger.info("Realizando POST");
      Matricula matricula = new Matricula();
      Enumeration<String> paramNames = req.getParameterNames();

      while (paramNames.hasMoreElements()) {
        String nameParam = paramNames.nextElement();
        logger.info(nameParam + ": " + req.getParameter(nameParam));}

      if(req.getParameter("Nombre") == null && req.getParameter("Nombre").contains("123456789")){
        logger.error("Nombre inválido");
        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setNombre(req.getParameter("Nombre"));
      }

      if(req.getParameter("Apellidos") == null && req.getParameter("Apellidos").contains("123456789")){
        logger.error("Apellidos inválidos");
        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setApellidos(req.getParameter("Apellidos"));
      }

      if(req.getParameter("Email") == null && req.getParameter("Nombre").contains("123456789")){
        logger.error("Email inválido");
        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setEmail(req.getParameter("Email"));
      }

      if(req.getParameter("Curso") == null){
        logger.error("Curso no introducido");
        resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
        return;
      } else {
        matricula.setCurso(req.getParameter("Curso"));
      }

      String[] asig = req.getParameterValues("Asignaturas");
      List<String> asignaturasBean = Arrays.asList(asig);
      matricula.setAsignaturas(asignaturasBean);
      logger.info(asignaturasBean.toString());

      logger.info(matricula.toString());
      session.setAttribute("matricula", matricula);
      resp.sendRedirect(req.getContextPath() + "/MatriculaServlet");
    } else {
      logger.error("No se ha recibido una sesión valida.");
      session.invalidate();
      resp.sendRedirect(req.getContextPath());
    }
  }

  /** */
  @Override
  public void destroy() {
    super.destroy();
  }
}
