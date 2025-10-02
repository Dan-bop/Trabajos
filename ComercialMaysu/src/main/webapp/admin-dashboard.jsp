<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Dashboard Administrativo</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

  <div class="container mt-4">
    <h2>📊 Dashboard Administrativo</h2>

    <div class="row text-center">
      <div class="col-md-3">
        <div class="card bg-light mb-3">
          <div class="card-body">
            <h5>Total Ventas</h5>
            <p class="fs-4 fw-bold">S/. ${totalVentas}</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card bg-light mb-3">
          <div class="card-body">
            <h5>Pedidos recientes</h5>
            <p class="fs-4 fw-bold">${totalPedidos}</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card bg-light mb-3">
          <div class="card-body">
            <h5>Clientes registrados</h5>
            <p class="fs-4 fw-bold">${totalClientes}</p>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card bg-light mb-3">
          <div class="card-body">
            <h5>Producto más vendido</h5>
            <p class="fs-5">${productoTop.nombre}</p>
            <p class="text-muted">Vendidos: ${productoTop.cantidad}</p>
          </div>
        </div>
      </div>
    </div>

    <a href="AdminProductosServlet" class="btn btn-primary">🛒 Ir a productos</a>
    <a href="AdminPedidosServlet" class="btn btn-secondary">📦 Ir a pedidos</a>
  </div>

</body>
</html>
