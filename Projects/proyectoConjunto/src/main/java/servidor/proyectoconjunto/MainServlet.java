package servidor.proyectoconjunto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    final static Logger logger = LoggerFactory.getLogger(MainServlet.class);

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
      logger.info("Iniciando GET");
      req.getRequestDispatcher("/WEB-INF/Views/botonEntrar.jsp").forward(req, resp);
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
      logger.info("Iniciando POST");
      logger.info(req.getParameter("botonEntrar"));
      if(req.getParameter("botonEntrar") != null && req.getParameter("botonEntrar").equals("LOGUEADO")){
          HttpSession session = req.getSession();
          session.setAttribute("LOGUEADO", true);
      resp.sendRedirect(req.getContextPath() + "/SeleccionServlet");
      } else {
          logger.error("No se ha recibido el parámetro correcto");
          resp.sendRedirect(req.getContextPath());
      }
  }

  /** */
  @Override
  public void destroy() {
    super.destroy();
  }
}
