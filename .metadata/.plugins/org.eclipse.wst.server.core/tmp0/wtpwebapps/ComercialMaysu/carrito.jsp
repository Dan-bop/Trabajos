<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Carrito de compras - Comercial Maysu</title>
  <link rel="stylesheet" href="estilos.css">
</head>
<body>

  <!-- Encabezado -->
  <header>
    <h1>Comercial Maysu</h1>
    <nav>
      <a href="home">Inicio</a> |
      <a href="catalogo">Catálogo</a> |
      <a href="carrito">Carrito</a> |
      <a href="login">Iniciar sesión</a>
    </nav>
  </header>

  <!-- Carrito -->
  <main>
    <h2>Tu carrito de compras</h2>
    <c:if test="${carrito == null || carrito.isEmpty()}">
      <p>No has agregado productos al carrito.</p>
    </c:if>

    <c:if test="${not empty carrito}">
      <table>
        <tr>
          <th>Producto</th>
          <th>Precio unitario</th>
          <th>Cantidad</th>
          <th>Subtotal</th>
          <th>Acciones</th>
        </tr>
        <c:set var="total" value="0" />
        <c:forEach var="item" items="${carrito}">
          <tr>
            <td>${item.producto.nombre}</td>
            <td>S/. ${item.precioUnitario}</td>
            <td>${item.cantidad}</td>
            <td>S/. ${item.precioUnitario * item.cantidad}</td>
            <td>
              <form action="carrito" method="post">
                <input type="hidden" name="idProducto" value="${item.producto.id}">
                <button name="accion" value="eliminar">Eliminar</button>
              </form>
            </td>
          </tr>
          <c:set var="total" value="${total + (item.precioUnitario * item.cantidad)}" />
        </c:forEach>
        <tr>
          <td colspan="3"><strong>Total:</strong></td>
          <td colspan="2"><strong>S/. ${total}</strong></td>
        </tr>
      </table>
      <a href="checkout">Continuar con la compra</a>
    </c:if>
  </main>

  <!-- Footer -->
  <footer>
    <p>© 2025 Comercial Maysu — Todos los derechos reservados</p>
    <p>
      <a href="contacto">Contacto</a> |
      <a href="info">Políticas</a> |
      Síguenos en Facebook, Instagram, WhatsApp
    </p>
  </footer>

</body>
</html>
