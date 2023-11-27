package com.example.jgd_crud_serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
@WebServlet(value = "/VolverServlet", name = "VolverServlet")
public class VolverServlet extends HttpServlet {

    Logger log = LoggerFactory.getLogger(VolverServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("WEB-INF/Views/botonVolver.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
