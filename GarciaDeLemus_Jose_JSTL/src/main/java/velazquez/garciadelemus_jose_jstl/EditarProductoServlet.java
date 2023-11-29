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

public class EditarProductoServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(AdminMainServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ProductoDAO productoDAO = new ProductoDAOImpl();
        ProductoBean producto = productoDAO.getProducto(req.getParameter("code"));
        session.setAttribute("producto", producto);
        log.info(producto.toString());
        ArrayList<String> categorias = productoDAO.getCategorias();
        session.setAttribute("categorias", categorias);
        log.info(categorias.toString());
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/editarProducto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        String codigo = req.getParameter("codigo");
        String nombre = req.getParameter("nombre");
        String categoria = req.getParameter("categoria");
        String stock = req.getParameter("stock");
        String precio = req.getParameter("precio");
        ProductoBean producto = new ProductoBean(codigo, nombre, categoria, stock, precio);
        ProductoDAO productoDAO = new ProductoDAOImpl();
    if (productoDAO.updateProducto(producto)) {
        log.info("Producto editado correctamente");
    } else {
        log.error("Error al editar el producto");
    }
    resp.sendRedirect(req.getContextPath() + "/AdminMain");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
