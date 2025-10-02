package controlador;

import java.io.IOException;
import java.util.List;

import dao.ClienteDAO;
import dao.PedidoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Cliente;
import modelo.Pedido;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Pedido> pedidos = new PedidoDAO().listarPorCliente(cliente.getId());
        request.setAttribute("cliente", cliente);
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("perfil.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Actualizar datos desde el formulario
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefono(request.getParameter("telefono"));
        cliente.setDireccion(request.getParameter("direccion"));

        new ClienteDAO().actualizar(cliente);
        session.setAttribute("cliente", cliente); // actualizar en sesión también

        request.setAttribute("mensaje", "✅ Perfil actualizado correctamente.");
        doGet(request, response); // recargar perfil con historial
    }
}
