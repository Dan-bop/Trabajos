package controlador;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.PedidoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Cliente;
import modelo.ItemCarrito;
import modelo.ItemPedido;
import modelo.Pedido;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<ItemCarrito> itemsCarrito = (List<ItemCarrito>) session.getAttribute("carrito");

        if (cliente == null || itemsCarrito == null || itemsCarrito.isEmpty()) {
            response.sendRedirect("catalogo.jsp");
            return;
        }

        String pago = request.getParameter("pago");
        String envio = request.getParameter("envio");

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFecha(new Timestamp(System.currentTimeMillis()));
        pedido.setMetodoPago(pago);
        pedido.setFormaEntrega(envio);
        pedido.setEstado("pendiente");

        // ✅ Convertir ItemCarrito → ItemPedido
        List<ItemPedido> itemsPedido = new ArrayList<>();
        for (ItemCarrito item : itemsCarrito) {
            ItemPedido ip = new ItemPedido();
            ip.setProducto(item.getProducto());
            ip.setCantidad(item.getCantidad());
            ip.setPrecioUnitario(item.getPrecioUnitario());
            ip.setPedido(pedido); // asociación bidireccional
            itemsPedido.add(ip);
        }

        pedido.setItems(itemsPedido); // ahora sí: List<ItemPedido>

        new PedidoDAO().guardar(pedido);
        session.removeAttribute("carrito");

        request.setAttribute("mensaje", "✅ Pedido registrado correctamente.");
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}
