<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Nuevo Producto</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>➕ Nuevo Producto</h2>

    <form action="AdminNuevoProductoServlet" method="post">
      <div class="mb-3">
        <label>Nombre:</label>
        <input type="text" name="nombre" class="form-control" required>
      </div>
      <div class="mb-3">
        <label>Descripción:</label>
        <textarea name="descripcion" class="form-control" rows="3"></textarea>
      </div>
      <div class="mb-3">
        <label>Precio:</label>
        <input type="number" step="0.01" name="precio" class="form-control" required>
      </div>
      <div class="mb-3">
        <label>Stock:</label>
        <input type="number" name="stock" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-success">Guardar producto</button>
      <a href="AdminProductosServlet" class="btn btn-secondary">← Volver</a>
    </form>
  </div>

</body>
</html>
