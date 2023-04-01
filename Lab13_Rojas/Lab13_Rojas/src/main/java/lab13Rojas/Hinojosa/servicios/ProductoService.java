package lab13Rojas.Hinojosa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab13Rojas.Hinojosa.modelo.Producto;
import lab13Rojas.Hinojosa.repositorios.IProducto;

@Service("productyy")
public class ProductoService {
	@Autowired
	private IProducto interfproduct;
	public void guardar(Producto productyy) {
		interfproduct.save(productyy);
	}
	
	public List<Producto> listprod (){
		return interfproduct.findAll();
	}
	
	public Producto searchprod(Long id) {
		return interfproduct.findByCodigo(id);
	}
	
	public boolean deleteprod (Long id) {
		try {
			interfproduct.delete(interfproduct.findByCodigo(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Producto searchprod(String name) {
		return interfproduct.findByNombre(name);
	}
}
