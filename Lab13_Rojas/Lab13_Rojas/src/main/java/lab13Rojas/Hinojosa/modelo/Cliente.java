package lab13Rojas.Hinojosa.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.jetbrains.annotations.NotNull;

@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String apellidos;
	
	@NotNull
	private String nombres;
	
	@NotNull
	private int dni;
	
	@NotNull
	private int telefono;
	
	@NotNull
	private String direccion;
	

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", apellidos=" + apellidos + ", nombres=" + nombres + ", dni=" + dni
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
}
