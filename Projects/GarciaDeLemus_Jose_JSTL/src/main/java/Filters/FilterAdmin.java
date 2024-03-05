package Filters;

import Models.UsuarioBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.garciadelemus_jose_jstl.AdminMainServlet;

import java.io.IOException;
@WebFilter(servletNames = {"AdminMain","Update"})
public class FilterAdmin implements Filter {

    final static Logger log = LoggerFactory.getLogger(FilterAdmin.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        UsuarioBean usuario = (UsuarioBean) session.getAttribute("usuario");
        if(session.isNew() || usuario == null || !usuario.getRole().equals("admin")){
            log.error("Ha habido un problema con tu sesión de admin");
            resp.sendRedirect(req.getContextPath());
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
