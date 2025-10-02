<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Comercial Maysu - Productos</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-4">
    <h2>Catálogo de Productos</h2>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Precio</th>
          <th>Stock</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="p" items="${productos}">
          <tr>
            <td>${p.id}</td>
            <td>${p.nombre}</td>
            <td>S/. ${p.precio}</td>
            <td>${p.stock}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
