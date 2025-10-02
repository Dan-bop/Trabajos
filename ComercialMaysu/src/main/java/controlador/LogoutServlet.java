package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalida la sesión actual
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirige al home
        response.sendRedirect("home");
    }
}
