<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Mis pedidos - Comercial Maysu</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="estilos.css">
</head>
<body>

  <div class="container mt-4">
    <h2>🧾 Historial de compras</h2>

    <c:if test="${empty pedidos}">
      <p class="text-muted">No tienes pedidos registrados aún.</p>
    </c:if>

    <c:forEach var="pedido" items="${pedidos}">
      <div class="card mb-3">
        <div class="card-header">
          <strong>Pedido #${pedido.id}</strong> — Fecha: ${pedido.fecha}
        </div>
        <div class="card-body">
          <table class="table table-sm">
            <thead>
              <tr>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Precio unitario</th>
                <th>Subtotal</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="detalle" items="${pedido.detalleCarritos}">
                <tr>
                  <td>${detalle.producto.nombre}</td>
                  <td>${detalle.cantidad}</td>
                  <td>S/. ${detalle.precioUnitario}</td>
                  <td>S/. ${detalle.precioUnitario * detalle.cantidad}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </c:forEach>
  </div>

</body>
</html>
