package velazquez.jgd_ejerciciotrimestral;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MostrarProductosServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(MostrarProductosServlet.class);

    public void init() {}

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("Realizando GET");
        log.info(req.getParameter("cat"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    public void destroy() {
    }
}