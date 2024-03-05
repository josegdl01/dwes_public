package velazquez.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import java.io.IOException;
import java.util.Enumeration;

public class MenuServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(MenuServlet.class);

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        if(session.isNew() || session.getAttribute("sesionCorrecta") == null || (boolean) session.getAttribute("sesionCorrecta")) {
            log.error("Sesión incorrecta");
            resp.sendRedirect(req.getContextPath());
        } else {
            req.getRequestDispatcher("/WEB-INF/Views/menu.jsp").forward(req, resp);
        }
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.isNew() || session.getAttribute("sesionCorrecta") == null || (boolean) session.getAttribute("sesionCorrecta")) {
            log.error("Sesión incorrecta");
            resp.sendRedirect(req.getContextPath());
        } else {
            Enumeration<String> paramNames = req.getParameterNames();

            if(paramNames.nextElement() == null){
                log.error("No se ha seleccionado ninguna opción");
            } else {

            }
        }
    }

    /**
     *
     */
    @Override
    public void destroy() {
        super.destroy();
    }
}
