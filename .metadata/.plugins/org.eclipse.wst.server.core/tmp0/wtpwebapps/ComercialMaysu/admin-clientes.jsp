<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Clientes</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>👥 Clientes Registrados</h2>

    <c:if test="${empty clientes}">
      <p>No hay clientes registrados.</p>
    </c:if>

    <c:if test="${not empty clientes}">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Teléfono</th>
            <th>Historial</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="c" items="${clientes}">
            <tr>
              <td>${c.id}</td>
              <td>${c.nombre}</td>
              <td>${c.email}</td>
              <td>${c.telefono}</td>
              <td>
                <a href="AdminHistorialClienteServlet?id=${c.id}" class="btn btn-sm btn-info">Ver compras</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </div>

</body>
</html>
