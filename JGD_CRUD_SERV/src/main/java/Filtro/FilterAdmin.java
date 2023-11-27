package Filtro;

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

@WebFilter(servletNames = {"DeleteServlet","InsertServlet","UpdateServlet"})
public class FilterAdmin implements jakarta.servlet.Filter {

    final static Logger log = LoggerFactory.getLogger(FilterAdmin.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        if(session.isNew() || session.getAttribute("sesionCorrecta") == null || !(boolean)session.getAttribute("sesionCorrecta")|| session.getAttribute("momentoInicio") == null){
            log.error("No tienes privilegios de administrador");
            resp.sendRedirect(req.getContextPath());
        } else {
            log.info(session.getAttribute("sesionCorrecta").toString());
            filterChain.doFilter(req, resp);
        }
    }
}
