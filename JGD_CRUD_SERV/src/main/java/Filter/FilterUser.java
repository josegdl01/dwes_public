package Filter;

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
        if (!session.isNew() && session.getAttribute("sesionCorrecta") != null && (boolean) session.getAttribute("sesionCorrecta") && session.getAttribute("momentoInicio") != null) {
            log.info("Iniciada sesión de admin\n" + session.getAttribute("sesionCorrecta") + "\n" + session.getAttribute("momentoInicio"));
            filterChain.doFilter(req, resp);
        } else if (!session.isNew() && session.getAttribute("sesionCorrecta") != null && !(boolean) session.getAttribute("sesionCorrecta") && session.getAttribute("momentoInicio") != null) {
            log.info("Iniciada sesión de usuario\n" + session.getAttribute("sesionCorrecta") + "\n" + session.getAttribute("momentoInicio"));
            filterChain.doFilter(req, resp);
        } else {
            log.error("Sesión recibida incorrecta");
            resp.sendRedirect(req.getContextPath());
        }
    }
}
