<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Envío</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>✏️ Editar opción de envío</h2>

    <form action="AdminEditarEnvioServlet" method="post">
      <input type="hidden" name="id" value="${envio.id}" />

      <div class="mb-3">
        <label>Nombre</label>
        <input type="text" name="nombre" class="form-control" value="${envio.nombre}" required />
      </div>

      <div class="mb-3">
        <label>Tipo</label>
        <select name="tipo" class="form-select">
          <option ${envio.tipo == 'Delivery' ? 'selected' : ''}>Delivery</option>
          <option ${envio.tipo == 'Recojo' ? 'selected' : ''}>Recojo</option>
        </select>
      </div>

      <div class="mb-3">
        <label>Costo</label>
        <input type="number" step="0.01" name="costo" class="form-control" value="${envio.costo}" required />
      </div>

      <button type="submit" class="btn btn-success">Guardar cambios</button>
      <a href="AdminPagosEnviosServlet" class="btn btn-secondary">← Volver</a>
    </form>
  </div>

</body>
</html>
