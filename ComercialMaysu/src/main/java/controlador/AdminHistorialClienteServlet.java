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

@WebServlet("/AdminHistorialClienteServlet")
public class AdminHistorialClienteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int clienteId = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new ClienteDAO().buscarPorId(clienteId);
        List<Pedido> pedidos = new PedidoDAO().listarPorCliente(clienteId);

        request.setAttribute("cliente", cliente);
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("admin-historial-cliente.jsp").forward(request, response);
    }
}
