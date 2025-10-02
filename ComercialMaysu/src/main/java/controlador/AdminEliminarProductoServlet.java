package controlador;

import java.io.IOException;
import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminEliminarProductoServlet")
public class AdminEliminarProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        new ProductoDAO().eliminar(id);
        response.sendRedirect("AdminProductosServlet");
    }
}
