package controlador;

import java.io.IOException;
import dao.EnvioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Envio;

@WebServlet("/AdminEditarEnvioServlet")
public class AdminEditarEnvioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Envio envio = new EnvioDAO().buscarPorId(id);

        request.setAttribute("envio", envio);
        request.getRequestDispatcher("admin-editar-envio.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        double costo = Double.parseDouble(request.getParameter("costo"));

        Envio envio = new EnvioDAO().buscarPorId(id);
        envio.setNombre(nombre);
        envio.setTipo(tipo);
        envio.setCosto(costo);

        new EnvioDAO().actualizar(envio);
        response.sendRedirect("AdminPagosEnviosServlet");
    }
}
