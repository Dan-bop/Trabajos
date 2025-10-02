<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Productos</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>🛒 Gestión de Productos</h2>
    <a href="admin-nuevo-producto.jsp" class="btn btn-success mb-3">➕ Nuevo producto</a>

    <c:if test="${empty productos}">
      <p>No hay productos registrados.</p>
    </c:if>

    <c:if test="${not empty productos}">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="p" items="${productos}">
            <tr>
              <td>${p.id}</td>
              <td>${p.nombre}</td>
              <td>S/. ${p.precio}</td>
              <td>${p.stock}</td>
              <td>
                <a href="AdminEditarProductoServlet?id=${p.id}" class="btn btn-sm btn-primary">✏️ Editar</a>
                <a href="AdminEliminarProductoServlet?id=${p.id}" class="btn btn-sm btn-danger" onclick="return confirm('¿Eliminar producto?')">❌ Eliminar</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </div>

</body>
</html>
