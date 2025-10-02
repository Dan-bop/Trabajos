package controlador;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Producto;
import modelo.ItemCarrito;
import dao.ProductoDAO;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
    private ProductoDAO productoDAO = new ProductoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }

        String accion = request.getParameter("accion");
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        if ("eliminar".equals(accion)) {
            carrito.removeIf(item -> item.getProducto().getId() == idProducto);
        } else {
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Producto producto = productoDAO.buscarPorId(idProducto);

            boolean encontrado = false;
            for (ItemCarrito item : carrito) {
                if (item.getProducto().getId() == idProducto) {
                    item.setCantidad(item.getCantidad() + cantidad);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                carrito.add(new ItemCarrito(producto, cantidad));
            }
        }

        response.sendRedirect("carrito.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("carrito.jsp").forward(request, response);
    }
}
