<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Recuperar contraseña - Comercial Maysu</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="estilos.css">
</head>
<body>

  <div class="container mt-4">
    <h2>🔐 Recuperar contraseña</h2>
    <form action="recuperar" method="post">
      <div class="mb-3">
        <label>Correo electrónico registrado:</label>
        <input type="email" name="email" class="form-control" required>
      </div>
      <div class="mb-3">
        <label>Nueva contraseña:</label>
        <input type="password" name="nuevaClave" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Actualizar contraseña</button>
    </form>

    <c:if test="${not empty mensaje}">
      <div class="alert alert-info mt-3">${mensaje}</div>
    </c:if>
  </div>

</body>
</html>
