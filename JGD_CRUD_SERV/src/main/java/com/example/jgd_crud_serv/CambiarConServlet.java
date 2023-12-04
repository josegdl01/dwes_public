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

public class CambiarConServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(CambiarConServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/formEditarContrasena.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Realizando POST");
        HttpSession session = req.getSession();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        UsuarioBean user = (UsuarioBean) session.getAttribute("user");
        if (!req.getParameter("oldPass").isEmpty() && PassGen.checkPassword(req.getParameter("oldPass"), user.getPass())) {
            if (req.getParameter("newPass").equals(req.getParameter("confirmPass"))
                    && !req.getParameter("newPass").isEmpty() && !req.getParameter("confirmPass").isEmpty()) {
                usuarioDAO.modContrasena(user.getPass(), PassGen.hashPassword(req.getParameter("confirmPass")));
                resp.sendRedirect(req.getContextPath() + "/AreaUsuario");
            } else {
                log.error("La contraseña y la confirmación no coinciden");
                resp.sendRedirect(req.getContextPath() + "/CambiarConServlet");
                return;
            }
        } else {
            log.error("La contraseña introducida no es correcta");
            resp.sendRedirect(req.getContextPath() + "/CambiarConServlet");
            return;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
