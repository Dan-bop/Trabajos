<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Pagos y Envíos</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>💳 Pagos y 🚚 Envíos</h2>

    <h4>Pagos recibidos</h4>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>ID Pedido</th>
          <th>Cliente</th>
          <th>Monto</th>
          <th>Método</th>
          <th>Fecha</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="pago" items="${pagos}">
          <tr>
            <td>${pago.pedido.id}</td>
            <td>${pago.pedido.cliente.nombre}</td>
            <td>S/. ${pago.monto}</td>
            <td>${pago.metodo}</td>
            <td>${pago.fecha}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <h4>Opciones de envío</h4>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Tipo</th>
          <th>Costo</th>
          <th>Editar</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="envio" items="${envios}">
          <tr>
            <td>${envio.nombre}</td>
            <td>${envio.tipo}</td>
            <td>S/. ${envio.costo}</td>
            <td>
              <a href="AdminEditarEnvioServlet?id=${envio.id}" class="btn btn-sm btn-primary">✏️</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <a href="AdminDashboardServlet" class="btn btn-secondary">← Volver al dashboard</a>
  </div>

</body>
</html>
