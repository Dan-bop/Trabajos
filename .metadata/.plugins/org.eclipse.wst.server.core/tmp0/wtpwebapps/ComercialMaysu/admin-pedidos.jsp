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
      <th>ID</th>
      <th>Cliente</th>
      <th>Fecha</th>
      <th>Estado</th>
      <th>Actualizar</th>
      <th>Total</th>
      <th>Detalle</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="p" items="${pedidos}">
      <tr>
        <td>${p.id}</td>
        <td>${p.cliente.nombre}</td>
        <td>${p.fecha}</td>
        <td>
          <form action="admin-pedidos" method="post" class="d-flex">
            <input type="hidden" name="id" value="${p.id}">
            <select name="estado" class="form-select me-2">
              <option value="pendiente" ${p.estado == 'pendiente' ? 'selected' : ''}>Pendiente</option>
              <option value="enviado" ${p.estado == 'enviado' ? 'selected' : ''}>Enviado</option>
              <option value="entregado" ${p.estado == 'entregado' ? 'selected' : ''}>Entregado</option>
              <option value="cancelado" ${p.estado == 'cancelado' ? 'selected' : ''}>Cancelado</option>
            </select>
            <button type="submit" class="btn btn-sm btn-primary">Actualizar</button>
          </form>
        </td>
        <td>S/. ${p.total}</td>
        <td>
          <a href="DetallePedidoServlet?id=${p.id}" class="btn btn-sm btn-info">Ver detalle</a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
    

    <p class="fw-bold">Total: S/. ${pedido.total}</p>
    <a href="admin-pedidos" class="btn btn-secondary">← Volver a pedidos</a>
  </div>

</body>
</html>
