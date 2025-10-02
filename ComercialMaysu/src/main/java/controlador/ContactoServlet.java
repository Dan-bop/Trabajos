package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ContactoServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String mensaje = request.getParameter("mensaje");

        // Aquí podrías guardar el mensaje en base de datos o enviarlo por correo
        // Por ahora, solo mostramos un mensaje de confirmación

        request.setAttribute("mensaje", "Gracias por contactarnos, " + nombre + ". Te responderemos pronto.");
        request.getRequestDispatcher("contacto.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("contacto.jsp").forward(request, response);
    }
}
