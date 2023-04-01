package lab13Rojas.Hinojosa.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lab13Rojas.Hinojosa.modelo.Cliente;
import lab13Rojas.Hinojosa.servicios.ClienteService;

@Controller
@RequestMapping("/clientespage")
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	ClienteService cliservpg;
	
	@RequestMapping("/listsubp")
	public String listarcontcliente (Model modcl) {
		List<Cliente> clilist = cliservpg.listconjunt();
		modcl.addAttribute("clientestag", clilist);
		return "clilist";
	}
	
	@RequestMapping("/formsubp")
	public String formulario (Map<String, Object> mod) {
		Cliente clientemodel = new Cliente();
		mod.put("cliente", clientemodel);
		mod.put("Regi2", "Registrar Cliente");
		return "clienteformulario";
	}
	
	@RequestMapping("/formsubp/{codigo}")
	public String actualizar (@PathVariable("codigo") Long codigo, Model mvv) {
		mvv.addAttribute("cliente", cliservpg.searchbuscar(codigo));
		mvv.addAttribute("Regi2", "Editar Cliente");
		return "clienteformulario";
	}
	
	@RequestMapping(value="/insertsubp", method=RequestMethod.POST)
	public String insertar(@Validated Cliente clinb, BindingResult resultnb, Model moins) {
		if(resultnb.hasErrors()) {
			moins.addAttribute("ERROR", "Error al registrar");
			clinb = new Cliente();
			moins.addAttribute("cliente", clinb);
			return "clienteformulario";
		}else {
			cliservpg.guardarz(clinb);
			return "redirect:/clientespage/listsubp";
		}
	}
	
	@RequestMapping("/elimsubp/{codigo}")
	public String eliminardel(@PathVariable("codigo") Long codigo) {
		cliservpg.eliminar(codigo);
		return "redirect:/clientespage/listsubp";
	}
}
