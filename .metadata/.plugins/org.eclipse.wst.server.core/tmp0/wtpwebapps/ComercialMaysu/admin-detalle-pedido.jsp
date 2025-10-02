<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Detalle del Pedido</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>🧾 Detalle del Pedido #${pedido.id}</h2>
    <p><strong>Cliente:</strong> ${pedido.cliente.nombre}</p>
    <p><strong>Fecha:</strong> ${pedido.fecha}</p>
    <p><strong>Estado:</strong> ${pedido.estado}</p>

    <h4>📦 Productos</h4>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Producto</th>
          <th>Cantidad</th>
          <th>Precio Unitario</th>
          <th>Subtotal</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${pedido.items}">
          <tr>
            <td>${item.producto.nombre}</td>
            <td>${item.cantidad}</td>
            <td>S/. ${item.precioUnitario}</td>
            <td>S/. ${item.subtotal}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <p class="fw-bold">Total: S/. ${pedido.total}</p>
    <a href="admin-pedidos" class="btn btn-secondary">← Volver a pedidos</a>
  </div>

</body>
</html>
