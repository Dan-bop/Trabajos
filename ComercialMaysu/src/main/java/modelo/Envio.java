package modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "envios")
public class Envio implements Serializable {

   
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String tipo; // Ej: "Recojo en tienda", "Delivery"
    private double costo;

    // Constructores
    public Envio() {}

    public Envio(String nombre, String tipo, double costo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.costo = costo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}
