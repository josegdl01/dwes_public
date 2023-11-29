package velazquez.garciadelemus_jose_jstl;

import Dao.OficinaDAO;
import Dao.OficinaDAOImpl;
import Models.OficinaBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OficinaServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(OficinaServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/buscadorOficinas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        String id = req.getParameter("oficinas");
        OficinaDAO oficinaDAO = new OficinaDAOImpl();
        OficinaBean oficina = oficinaDAO.getOficina(id);
        req.getSession().setAttribute("oficina", oficina);
        log.info(oficina.toString());
        req.getRequestDispatcher("/WEB-INF/Views/buscadorOficinas.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
