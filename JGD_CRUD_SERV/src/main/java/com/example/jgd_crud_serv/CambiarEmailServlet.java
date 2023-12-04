package com.example.jgd_crud_serv;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Modelo.UsuarioBean;
import Utilidades.PassGen;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CambiarEmailServlet  extends HttpServlet {

    Logger log = LoggerFactory.getLogger(CambiarEmailServlet.class);


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/formEditarEmail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        HttpSession session = req.getSession();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        UsuarioBean user = (UsuarioBean) session.getAttribute("user");
        if (!req.getParameter("newEmail").isEmpty()) {
            if (usuarioDAO.modEmail(user.getEmail(), req.getParameter("newEmail"))) {
                log.info("Cambio de email realizado con éxito");
                resp.sendRedirect(req.getContextPath() + "/AreaUsuario");
            } else {
                log.error("Ha habido un error cambiando el email");
                resp.sendRedirect(req.getContextPath() + "/CambiarEmail");
                return;
            }
        } else {
            log.error("Rellene el campo de email");
            resp.sendRedirect(req.getContextPath() + "/CambiarEmail");
            return;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
