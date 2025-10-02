package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ProductoDAO;
import modelo.Producto;

@WebServlet("/detalle")
public class DetalleProductoServlet extends HttpServlet {
    private ProductoDAO productoDAO = new ProductoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Producto producto = productoDAO.buscarPorId(id);
        request.setAttribute("producto", producto);
        request.getRequestDispatcher("detalle.jsp").forward(request, response);
    }
}
