package Filtro;

import Modelo.UsuarioBean;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

//@WebFilter("/admin")
@WebFilter(servletNames = {"Delete", "Insert", "Update"})
public class FilterAdmin implements jakarta.servlet.Filter {
    final static Logger log = LoggerFactory.getLogger(FilterAdmin.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        UsuarioBean user = (UsuarioBean) session.getAttribute("user");
        if(!session.isNew() && user != null && user.getRole().equalsIgnoreCase("admin")){
            filterChain.doFilter(req, resp);
        } else {
            log.error("No tienes privilegios de administrador");
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }
    }
}
