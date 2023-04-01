package lab13Rojas.Hinojosa.repositorios;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab13Rojas.Hinojosa.modelo.Producto;

@Repository
public interface IProducto extends JpaRepository<Producto, Serializable>{
	public abstract Producto findByCodigo(Long codigo);
	public abstract Producto findByNombre(String producto);
}
