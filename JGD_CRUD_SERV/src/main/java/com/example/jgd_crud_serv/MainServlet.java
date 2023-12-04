package com.example.jgd_crud_serv;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Modelo.UsuarioBean;
import Utilidades.PassGen;
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
        UsuarioDAO userDAO = new UsuarioDAOImpl();
        String name = req.getParameter("name");
        UsuarioBean user = userDAO.getUsuario(name);
        String pass = req.getParameter("pswd");
        if(user != null){
            log.info(user.toString());
            if(PassGen.checkPassword(pass, user.getPass())){
                HttpSession session = req.getSession();
                session.setAttribute("user",userDAO.getUsuario(req.getParameter("name")));
                resp.sendRedirect(req.getContextPath() + "/Menu");
            } else {
                log.error("Contraseña incorrecta.");
                resp.sendRedirect(req.getContextPath());

            }
        } else {
            log.error("Este usuario no se encuentra en la base de datos.");
            resp.sendRedirect(req.getContextPath());
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
