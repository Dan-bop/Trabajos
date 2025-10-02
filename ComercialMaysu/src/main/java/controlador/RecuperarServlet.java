package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Cliente;
import dao.ClienteDAO;

@WebServlet("/recuperar")
public class RecuperarServlet extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String nuevaClave = request.getParameter("nuevaClave");

        Cliente cliente = clienteDAO.buscarPorCorreo(email);

        if (cliente == null) {
            request.setAttribute("mensaje", "No se encontró una cuenta con ese correo.");
        } else {
            cliente.setPassword(nuevaClave);
            clienteDAO.actualizar(cliente);
            request.setAttribute("mensaje", "Contraseña actualizada correctamente.");
        }

        request.getRequestDispatcher("recuperar.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("recuperar.jsp").forward(request, response);
    }
}
