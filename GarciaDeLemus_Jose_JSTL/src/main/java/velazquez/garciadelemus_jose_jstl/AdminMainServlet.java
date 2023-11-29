package velazquez.garciadelemus_jose_jstl;

import Dao.ProductoDAO;
import Dao.ProductoDAOImpl;
import Models.ProductoBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMainServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(AdminMainServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ProductoDAO productoDAO = new ProductoDAOImpl();
        ArrayList<ProductoBean> productos = productoDAO.getProductos();
        session.setAttribute("productos", productos);
        log.info(productos.toString());
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/mainAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
