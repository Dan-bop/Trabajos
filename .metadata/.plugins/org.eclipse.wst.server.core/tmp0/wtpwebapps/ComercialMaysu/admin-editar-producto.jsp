<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Producto</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>✏️ Editar Producto</h2>

    <form action="AdminEditarProductoServlet" method="post">
      <input type="hidden" name="id" value="${producto.id}">
      <div class="mb-3">
        <label>Nombre:</label>
        <input type="text" name="nombre" class="form-control" value="${producto.nombre}" required>
      </div>
      <div class="mb-3">
        <label>Descripción:</label>
        <textarea name="descripcion" class="form-control" rows="3">${producto.descripcion}</textarea>
      </div>
      <div class="mb-3">
        <label>Precio:</label>
        <input type="number" step="0.01" name="precio" class="form-control" value="${producto.precio}" required>
      </div>
      <div class="mb-3">
        <label>Stock:</label>
        <input type="number" name="stock" class="form-control" value="${producto.stock}" required>
      </div>
      <button type="submit" class="btn btn-primary">Guardar cambios</button>
      <a href="AdminProductosServlet" class="btn btn-secondary">← Volver</a>
    </form>
  </div>

</body>
</html>
