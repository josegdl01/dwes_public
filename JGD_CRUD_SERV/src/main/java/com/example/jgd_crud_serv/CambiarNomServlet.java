package com.example.jgd_crud_serv;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Modelo.UsuarioBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CambiarNomServlet extends HttpServlet {

    Logger log = LoggerFactory.getLogger(CambiarNomServlet.class);


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/formEditarNombre.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        HttpSession session = req.getSession();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        UsuarioBean user = (UsuarioBean) session.getAttribute("user");
        if (!req.getParameter("newName").isEmpty()) {
            if (usuarioDAO.modUsername(user.getName(), req.getParameter("newName"))) {
                log.info("Cambio de nombre de usuario realizado con éxito");
                resp.sendRedirect(req.getContextPath() + "/AreaUsuario");
            } else {
                log.error("Ha habido un error cambiando el nombre de usuario");
                resp.sendRedirect(req.getContextPath() + "/CambiarNombre");
                return;
            }
        } else {
            log.error("Rellene el campo de email");
            resp.sendRedirect(req.getContextPath() + "/CambiarNombre");
            return;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
