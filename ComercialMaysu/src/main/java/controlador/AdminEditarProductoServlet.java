package controlador;

import java.io.IOException;
import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Producto;
import java.math.BigDecimal;

@WebServlet("/AdminEditarProductoServlet")
public class AdminEditarProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Producto producto = new ProductoDAO().buscarPorId(id);

        if (producto == null) {
            response.sendRedirect("AdminProductosServlet");
            return;
        }

        request.setAttribute("producto", producto);
        request.getRequestDispatcher("admin-editar-producto.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        BigDecimal precio = new BigDecimal(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new ProductoDAO().buscarPorId(id);
        if (producto != null) {
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(stock);
            new ProductoDAO().actualizar(producto);
        }

        response.sendRedirect("AdminProductosServlet");
    }
}
