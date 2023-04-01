package lab13Rojas.Hinojosa.servicios;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab13Rojas.Hinojosa.modelo.Cliente;
import lab13Rojas.Hinojosa.repositorios.ICliente;

@Service("clienteq")
public class ClienteService {
	
	@Autowired
	private ICliente interclient;
	public void guardarz(Cliente clienteq) {   //void method
		interclient.save(clienteq);     //method save JpaRepository
	} 
	
	public List<Cliente> listconjunt(){  //list type method
		return interclient.findAll();  //method findAll JpaRepository
	}
	
	public Cliente searchbuscar(Long codigo) {    //class instanced method
		return interclient.findByCodigo(codigo);  //method findById() JpaRepository
	}
	
	public boolean eliminar(Long codigo) {  //boolean method
		try {
			interclient.delete(interclient.findByCodigo(codigo));  //method delete() JpaRepository
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
