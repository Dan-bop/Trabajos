package controlador;

import java.io.IOException;
import java.util.List;

import dao.PedidoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Pedido;

@WebServlet("/admin-pedidos")
public class AdminPedidosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pedido> pedidos = new PedidoDAO().listarTodos();
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("admin-pedidos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");

        new PedidoDAO().actualizarEstado(id, estado);
        request.setAttribute("mensaje", "✅ Estado actualizado correctamente.");

        doGet(request, response); // recargar lista con mensaje
    }
}
