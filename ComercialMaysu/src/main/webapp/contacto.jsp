<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Contáctanos - Comercial Maysu</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-4">
    <h2>📬 Contáctanos</h2>
    <form action="contacto" method="post">
      <div class="mb-3">
        <label>Nombre:</label>
        <input type="text" name="nombre" class="form-control" required>
      </div>
      <div class="mb-3">
        <label>Correo:</label>
        <input type="email" name="correo" class="form-control" required>
      </div>
      <div class="mb-3">
        <label>Mensaje:</label>
        <textarea name="mensaje" class="form-control" rows="4" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Enviar</button>
    </form>

    <c:if test="${not empty mensaje}">
      <div class="alert alert-info mt-3">${mensaje}</div>
    </c:if>
  </div>
</body>
</html>

