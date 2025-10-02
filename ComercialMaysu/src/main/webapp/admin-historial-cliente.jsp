<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Historial de Compras</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>🧾 Historial de Compras de ${cliente.nombre}</h2>

    <c:if test="${empty pedidos}">
      <p>Este cliente no ha realizado compras aún.</p>
    </c:if>

    <c:if test="${not empty pedidos}">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>ID Pedido</th>
            <th>Fecha</th>
            <th>Estado</th>
            <th>Total</th>
            <th>Detalle</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="p" items="${pedidos}">
            <tr>
              <td>${p.id}</td>
              <td>${p.fecha}</td>
              <td>${p.estado}</td>
              <td>S/. ${p.total}</td>
              <td>
                <a href="DetallePedidoServlet?id=${p.id}" class="btn btn-sm btn-info">Ver detalle</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>

    <a href="AdminClientesServlet" class="btn btn-secondary">← Volver a clientes</a>
  </div>

</body>
</html>
