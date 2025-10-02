package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Cliente;
import modelo.UsuarioAdmin;
import dao.ClienteDAO;
import dao.UsuarioAdminDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo"); // cliente o interno

        if ("cliente".equals(tipo)) {
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");

            Cliente cliente = clienteDAO.validar(correo, clave);

            if (cliente != null) {
                HttpSession session = request.getSession();
                session.setAttribute("cliente", cliente);
                response.sendRedirect("home");
            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("interno".equals(tipo)) {
            String username = request.getParameter("correo"); // mismo campo reutilizado
            String password = request.getParameter("clave");

            UsuarioAdmin usuario = new UsuarioAdminDAO().buscarPorUsername(username);

            if (usuario != null && usuario.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario.getUsername());
                session.setAttribute("rol", usuario.getRol());
                response.sendRedirect("AdminDashboardServlet");
            } else {
                request.setAttribute("error", "Usuario o contraseña inválidos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}