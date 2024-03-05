package Filters;

import Models.UsuarioBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
@WebFilter(servletNames = {"MostrarProductos"})
public class UserFilter implements Filter {

    final static Logger log = LoggerFactory.getLogger(UserFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        UsuarioBean usuario = (UsuarioBean) session.getAttribute("usuario");
        if(session.isNew() || usuario == null || !usuario.getRole().equals("user")){
            log.error("Ha habido un problema con tu sesión de usuario");
            resp.sendRedirect(req.getContextPath());
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
