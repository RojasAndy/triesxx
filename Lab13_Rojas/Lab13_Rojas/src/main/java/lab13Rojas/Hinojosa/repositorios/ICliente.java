package lab13Rojas.Hinojosa.repositorios;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab13Rojas.Hinojosa.modelo.Cliente;

@Repository
public interface ICliente extends JpaRepository<Cliente, Serializable> {
	public abstract Cliente findByCodigo(Long codigo);
}
