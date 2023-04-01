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

import lab13Rojas.Hinojosa.modelo.Producto;
import lab13Rojas.Hinojosa.servicios.ProductoService;

@Controller
@RequestMapping("/productospage")
@SessionAttributes("producto")
public class ProductoController {
	@Autowired
	ProductoService prserv;
	
	@RequestMapping("/listprod")
	public String listproduction(Model vbv) {
		List<Producto> prolist = prserv.listprod();
		vbv.addAttribute("productotag", prolist);
		return "prolist";
	}
	
	@RequestMapping("/formproduct")
	public String formulapro (Map<String, Object> moas) {
		Producto prodmodelc = new Producto();
		moas.put("producto", prodmodelc);
		moas.put("Regi","Registrar Producto");
		return "productoformulario";
	}
	
	@RequestMapping("/formproduct/{codigo}")
	public String actualiprod (@PathVariable("codigo") Long codigo, Model mrr) {
		mrr.addAttribute("producto", prserv.searchprod(codigo));
		mrr.addAttribute("Regi","Editar Producto");
		return "productoformulario";
	}
	
	@RequestMapping(value="/insertprod", method=RequestMethod.POST)
	public String inserprod(@Validated Producto pronbf, BindingResult prodnb, Model jkl) {
		if(prodnb.hasErrors()) {
			jkl.addAttribute("ERROR", "Error al registrar");
			pronbf = new Producto();
			jkl.addAttribute("producto", pronbf);
			return "productoformulario";
		}else {
			prserv.guardar(pronbf);
			return "redirect:/productospage/listprod";
		}
	}
	
	@RequestMapping("/elimiproduct/{codigo}")
	public String deletproducto(@PathVariable("codigo") Long codigo) {
		prserv.deleteprod(codigo);
		return "redirect:/productospage/listprod";
	}
}
