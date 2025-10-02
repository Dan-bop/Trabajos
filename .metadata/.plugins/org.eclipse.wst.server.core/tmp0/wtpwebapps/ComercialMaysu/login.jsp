<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Iniciar sesión</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-5">
    <h2 class="text-center">🔐 Iniciar sesión</h2>

    <c:if test="${not empty error}">
      <div class="alert alert-danger">${error}</div>
    </c:if>

    <div class="row">
      <!-- Cliente -->
      <div class="col-md-6">
        <h4>👤 Cliente</h4>
        <form action="login" method="post">
          <input type="hidden" name="tipo" value="cliente" />
          <div class="mb-3">
            <label>Correo electrónico</label>
            <input type="email" name="correo" class="form-control" required />
          </div>
          <div class="mb-3">
            <label>Contraseña</label>
            <input type="password" name="clave" class="form-control" required />
          </div>
          <button type="submit" class="btn btn-primary">Ingresar</button>
        </form>
      </div>

      <!-- Usuario interno -->
      <div class="col-md-6">
        <h4>🧑‍💼 Usuario interno</h4>
        <form action="login" method="post">
          <input type="hidden" name="tipo" value="interno" />
          <div class="mb-3">
            <label>Usuario</label>
            <input type="text" name="correo" class="form-control" required />
          </div>
          <div class="mb-3">
            <label>Contraseña</label>
            <input type="password" name="clave" class="form-control" required />
          </div>
          <button type="submit" class="btn btn-dark">Acceder</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
