package modelo;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;



@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp fecha;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to DetalleCarrito
	@OneToMany(mappedBy="carrito")
	private List<DetalleCarrito> detalleCarritos;

	public Carrito() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleCarrito> getDetalleCarritos() {
		return this.detalleCarritos;
	}

	public void setDetalleCarritos(List<DetalleCarrito> detalleCarritos) {
		this.detalleCarritos = detalleCarritos;
	}

	public DetalleCarrito addDetalleCarrito(DetalleCarrito detalleCarrito) {
		getDetalleCarritos().add(detalleCarrito);
		detalleCarrito.setCarrito(this);

		return detalleCarrito;
	}

	public DetalleCarrito removeDetalleCarrito(DetalleCarrito detalleCarrito) {
		getDetalleCarritos().remove(detalleCarrito);
		detalleCarrito.setCarrito(null);

		return detalleCarrito;
	}

}