package controlador;

import java.io.IOException;
import java.util.List;

import dao.EnvioDAO;
import dao.PagoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Envio;
import modelo.Pago;

@WebServlet("/AdminPagosEnviosServlet")
public class AdminPagosEnviosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pago> pagos = new PagoDAO().listarTodos();
        List<Envio> envios = new EnvioDAO().listarTodos();

        request.setAttribute("pagos", pagos);
        request.setAttribute("envios", envios);
        request.getRequestDispatcher("admin-pagos-envios.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
