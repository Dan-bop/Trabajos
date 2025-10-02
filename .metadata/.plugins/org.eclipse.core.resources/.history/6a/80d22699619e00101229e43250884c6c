<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Catálogo - Comercial Maysu</title>
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

  <!-- Catálogo de productos -->
  <main>
    <h2>Todos los productos</h2>
    <section>
      <c:forEach var="p" items="${productos}">
        <article>
          <img src="img/productos/${p.imagen}" alt="${p.nombre}" width="150">
          <h3>${p.nombre}</h3>
          <p>Precio: S/. ${p.precio}</p>
          <a href="detalle?id=${p.id}">Ver más</a>
        </article>
      </c:forEach>
      <c:if test="${productos == null || productos.isEmpty()}">
        <p>No hay productos disponibles en este momento.</p>
      </c:if>
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
