package controlador;

import java.io.IOException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Cliente;
import dao.ClienteDAO;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validar si el correo ya existe
        if (clienteDAO.existeCorreo(email)) {
            request.setAttribute("mensaje", "Ya existe una cuenta con ese correo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        // Crear nuevo cliente
        Cliente nuevo = new Cliente();
        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setPassword(password);
        nuevo.setFechaRegistro(new Timestamp(System.currentTimeMillis()));

        clienteDAO.guardar(nuevo);

        request.setAttribute("mensaje", "Registro exitoso. Ahora puedes iniciar sesión.");
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
}
