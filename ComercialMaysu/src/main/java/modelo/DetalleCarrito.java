package modelo;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_carrito database table.
 * 
 */
@Entity
@Table(name="detalle_carrito")
@NamedQuery(name="DetalleCarrito.findAll", query="SELECT d FROM DetalleCarrito d")
public class DetalleCarrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Carrito
	@ManyToOne
	private Carrito carrito;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	public DetalleCarrito() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Carrito getCarrito() {
		return this.carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}