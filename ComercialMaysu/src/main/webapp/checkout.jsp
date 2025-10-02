<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Finalizar compra - Comercial Maysu</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container mt-4">
    <h2>🛒 Finalizar compra</h2>

    <form action="checkout" method="post">
      <div class="mb-3">
        <label>Método de pago:</label>
        <select name="pago" class="form-select" required>
          <option value="yape">Yape</option>
          <option value="tarjeta">Tarjeta</option>
          <option value="transferencia">Transferencia</option>
        </select>
      </div>

      <div class="mb-3">
        <label>Forma de entrega:</label>
        <select name="envio" class="form-select" required>
          <option value="envio">Envío a domicilio</option>
          <option value="recojo">Recojo en tienda</option>
        </select>
      </div>

      <button type="submit" class="btn btn-success">Confirmar pedido</button>
    </form>
  </div>
</body>
</html>
