<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Mi perfil - Comercial Maysu</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="estilos.css">
</head>
<body>

  <div class="container mt-4">
    <h2>👤 Mi perfil</h2>

    <form action="perfil" method="post">
      <div class="mb-3">
        <label>Nombre:</label>
        <input type="text" name="nombre" class="form-control" value="${sessionScope.cliente.nombre}" required>
      </div>
      <div class="mb-3">
        <label>Correo electrónico:</label>
        <input type="email" name="email" class="form-control" value="${sessionScope.cliente.email}" required>
      </div>
      <div class="mb-3">
        <label>Teléfono:</label>
        <input type="text" name="telefono" class="form-control" value="${sessionScope.cliente.telefono}">
      </div>
      <div class="mb-3">
        <label>Dirección:</label>
        <input type="text" name="direccion" class="form-control" value="${sessionScope.cliente.direccion}">
      </div>
      <button type="submit" class="btn btn-primary">Actualizar perfil</button>
    </form>

    <c:if test="${not empty mensaje}">
      <div class="alert alert-info mt-3">${mensaje}</div>
    </c:if>
  </div>

</body>
</html>
