package Filter;

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
@WebFilter(servletNames = {"ServletMatricular","SeleccionServlet"})
public class Filter implements jakarta.servlet.Filter {

  static final Logger log = LoggerFactory.getLogger(Filter.class);

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
    log.info("Aplicando filtro");
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    HttpSession session = req.getSession();
    if (session.isNew()
        || session.getAttribute("LOGUEADO") == null
        || !(boolean) session.getAttribute("LOGUEADO")) {
      log.error("Sesion incorrecta");
      resp.sendRedirect(req.getContextPath());
    } else {
      log.info("Sesion aceptada");
      chain.doFilter(servletRequest, servletResponse);
    }
  }
}
