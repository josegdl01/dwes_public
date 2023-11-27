package com.example.jgd_crud_serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(MainServlet.class);
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/formularioEntrada.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        if(req.getParameter("name").equals("root") && req.getParameter("pswd").equals("XXXXX")){
            log.info("Iniciada sesión de admin");
            HttpSession session = req.getSession();
            session.setAttribute("sesionCorrecta", true);
            String momentoInicio = LocalDateTime.now().getHour() +" : "+ LocalDateTime.now().getMinute() +" del " +LocalDateTime.now().getDayOfMonth() +" de "+ LocalDateTime.now().getMonth();
            session.setAttribute("momentoInicio", momentoInicio);
            resp.sendRedirect(req.getContextPath() + "/MenuServlet");
        } else {
            log.info("Iniciada sesión de usuario");
            HttpSession session = req.getSession();
            session.setAttribute("sesionCorrecta", false);
            String momentoInicio = LocalDateTime.now().getHour() +" : "+ LocalDateTime.now().getMinute() +" del " +LocalDateTime.now().getDayOfMonth() +" de "+ LocalDateTime.now().getMonth();
            session.setAttribute("momentoInicio", momentoInicio);
            resp.sendRedirect(req.getContextPath() + "/MenuServlet");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
