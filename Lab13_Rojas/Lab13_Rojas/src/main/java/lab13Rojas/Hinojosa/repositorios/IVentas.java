package lab13Rojas.Hinojosa.repositorios;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab13Rojas.Hinojosa.modelo.Ventas;

@Repository
public interface IVentas extends JpaRepository<Ventas, Serializable>{
	public abstract Ventas findByCodigo(Long codigo);
}
