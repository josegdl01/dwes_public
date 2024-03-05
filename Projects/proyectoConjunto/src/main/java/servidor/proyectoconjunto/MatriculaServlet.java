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

@WebServlet("/MatriculaServlet")
public class MatriculaServlet extends HttpServlet {
    final static Logger logger = LoggerFactory.getLogger(MatriculaServlet.class);

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
      HttpSession session = req.getSession();
      if (!session.isNew()
              && (boolean) session.getAttribute("LOGUEADO")) {
          logger.info("Realizando GET");
          req.getRequestDispatcher("/WEB-INF/Views/matricula.jsp").forward(req, resp);
      } else {
          logger.error("No se ha recibido una sesión valida.");
          session.invalidate();
          resp.sendRedirect(req.getContextPath());
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

  }

  /** */
  @Override
  public void destroy() {
    super.destroy();
  }
}
