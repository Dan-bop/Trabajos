package controlador;

import java.io.IOException;
import java.util.List;

import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Producto;

@WebServlet("/AdminProductosServlet")
public class AdminProductosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Producto> productos = new ProductoDAO().listarTodos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("admin-productos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // no se usa POST aquí
    }
}
