<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Detalle del producto - Comercial Maysu</title>
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

  <!-- Detalle del producto -->
  <main>
    <h2>${producto.nombre}</h2>
    <section>
      <img src="img/productos/${producto.imagen}" alt="${producto.nombre}" width="250">
      <p><strong>Descripción:</strong> ${producto.descripcion}</p>
      <p><strong>Precio:</strong> S/. ${producto.precio}</p>
      <p><strong>Stock disponible:</strong> ${producto.stock}</p>
      <p><strong>Unidad de medida:</strong> ${producto.unidadMedida}</p>
      <form action="carrito" method="post">
        <input type="hidden" name="idProducto" value="${producto.id}">
        <label>Cantidad:</label>
        <input type="number" name="cantidad" value="1" min="1" max="${producto.stock}">
        <button type="submit">Agregar al carrito</button>
      </form>
    </section>
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
