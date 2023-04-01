package lab13Rojas.Hinojosa.modelo;
import org.jetbrains.annotations.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
    @NotNull
	private String nombre;
    
    @NotNull
	private int stock;
    
    @NotNull
	private double precio;
    
    
    
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + "]";
	}
}
