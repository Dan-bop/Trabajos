package controlador;

import java.io.IOException;
import dao.PedidoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Pedido;

@WebServlet("/DetallePedidoServlet")
public class DetallePedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("admin-pedidos");
            return;
        }

        int id = Integer.parseInt(idParam);
        Pedido pedido = new PedidoDAO().buscarPorId(id);

        if (pedido == null) {
            response.sendRedirect("admin-pedidos");
            return;
        }

        request.setAttribute("pedido", pedido);
        request.getRequestDispatcher("admin-detalle-pedido.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // no se usa POST aquí
    }
}
