package controlador;

import java.io.IOException;
import java.util.List;

import dao.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Cliente;

@WebServlet("/AdminClientesServlet")
public class AdminClientesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientes = new ClienteDAO().listarTodos();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("admin-clientes.jsp").forward(request, response);
    }
}
