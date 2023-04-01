package lab13Rojas.Hinojosa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab13Rojas.Hinojosa.modelo.Ventas;
import lab13Rojas.Hinojosa.repositorios.IVentas;

@Service("ventasell")
public class VentasService {
	@Autowired
	private IVentas interfventas;
	public void guardar(Ventas ventasell) {
		interfventas.save(ventasell);
	}
	
	public List<Ventas> listvent() {
		return interfventas.findAll();
	}
	
	public Ventas searchvent(Long codigo) {
		return interfventas.findByCodigo(codigo);
	}
	
	public boolean deletevent (Long codigo) {
		try {
			interfventas.delete(interfventas.findByCodigo(codigo));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
