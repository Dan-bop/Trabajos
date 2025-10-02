package controlador;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Carrito;
import dao.CarritoDAO;
import modelo.Cliente;

@WebServlet("/historial")
public class HistorialServlet extends HttpServlet {
    private CarritoDAO carritoDAO = new CarritoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente == null) {
            response.sendRedirect("login");
            return;
        }

        List<Carrito> pedidos = carritoDAO.listarPorCliente(cliente.getId());
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("historial.jsp").forward(request, response);
    }
}
