package filtro;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/admin/*")
public class FiltroAdmin implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sesion = req.getSession(false);

        if (sesion != null && sesion.getAttribute("rol") != null) {
            String rol = (String) sesion.getAttribute("rol");

            if ("ADMIN".equals(rol) || "GERENTE".equals(rol)) {
                chain.doFilter(request, response);
                return;
            }
        }

        ((HttpServletResponse) response).sendRedirect("../login.jsp");
    }
}
