package lab13Rojas.Hinojosa.modelo;

import java.io.Serializable;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="VENTAS")
public class Ventas implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@NotNull
	private String codigo_cli;
	
	@NotNull
	private String codigo_produ;
	
	@NotNull
	private int cantidad;
	
	@NotNull
	private double subtotal;
	
	@NotNull
	private String igv;
	
	@NotNull
	private double total;
	
	@PrePersist      //permite autogenerar la fecha
	public void prePersist() {
		fecha = new Date();	
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigo_cli() {
		return codigo_cli;
	}

	public void setCodigo_cli(String codigo_cli) {
		this.codigo_cli = codigo_cli;
	}

	public String getCodigo_produ() {
		return codigo_produ;
	}

	public void setCodigo_produ(String codigo_produ) {
		this.codigo_produ = codigo_produ;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getIgv() {
		return igv;
	}

	public void setIgv(String igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Ventas [codigo=" + codigo + ", fecha=" + fecha + ", codigo_cli=" + codigo_cli + ", codigo_produ="
				+ codigo_produ + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", igv=" + igv + ", total="
				+ total + "]";
	}

}
