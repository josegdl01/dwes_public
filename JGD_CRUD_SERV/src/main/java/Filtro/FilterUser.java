package Filtro;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Modelo.UsuarioBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(servletNames = {"ReadServlet", "MenuServlet", "VolverServlet"})
public class FilterUser implements Filter {

    final static Logger log = LoggerFactory.getLogger(FilterUser.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        UsuarioBean user = (UsuarioBean) session.getAttribute("user");
        if(!session.isNew() &&  user != null){
            filterChain.doFilter(req, resp);
        } else {
            log.error("No se ha iniciado sesión correctamente");
        }
    }
}
