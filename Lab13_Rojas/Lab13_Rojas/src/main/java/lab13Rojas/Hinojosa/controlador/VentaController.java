package lab13Rojas.Hinojosa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lab13Rojas.Hinojosa.modelo.Producto;
import lab13Rojas.Hinojosa.modelo.Ventas;
import lab13Rojas.Hinojosa.servicios.ClienteService;
import lab13Rojas.Hinojosa.servicios.ProductoService;
import lab13Rojas.Hinojosa.servicios.VentasService;

@Controller
@RequestMapping("/ventapage")
@SessionAttributes("ventas")
public class VentaController {
	@Autowired
	VentasService vsr;
	
	@Autowired
	ClienteService clsvr;
	
	@Autowired
	ProductoService prsrv;
	
	@RequestMapping("/listvent")
	public String listvent(Model mnb) {
		List<Ventas> ventmodlist = vsr.listvent();
		mnb.addAttribute("ventastag", ventmodlist);
		return "ventlist";
	}
	
	@RequestMapping("/formvent")
	public String formulventas(Model mxmt) {
		Ventas sell = new Ventas();
		mxmt.addAttribute("ventas", sell);
		mxmt.addAttribute("prosp", prsrv.listprod());
		mxmt.addAttribute("clpass", clsvr.listconjunt());
		mxmt.addAttribute("Regi3", "Registrar Venta");
		return "ventaformulario";
	}
	
	@RequestMapping(value="/insertvent", method=RequestMethod.POST)
	public String savevent(@Validated Ventas sell, Model msav) {
		try {
			String codigox = sell.getCodigo_produ();
			Producto prod = prsrv.searchprod(codigox);
			
			if(sell.getCantidad() <= prod.getStock()) {
				int difference = prod.getStock() - sell.getCantidad();
				prod.setStock(difference);
				double alltot = prod.getPrecio() * sell.getCantidad();
				sell.setSubtotal(alltot);
				double igvbnb = alltot * 0.18;
				double totallity = igvbnb + alltot;
				sell.setTotal(totallity);
				prsrv.guardar(prod);
				vsr.guardar(sell);
			}else {
				msav.addAttribute("ERROR", "No hay stock para este producto, solo tenemos un stock de: "+prod.getStock());
				sell = new Ventas();
			    msav.addAttribute("ventas", sell);
			    msav.addAttribute("prosp", prsrv.listprod());
			    msav.addAttribute("clpass", clsvr.listconjunt());
			    return "ventaformulario";
			}
		}catch(Exception e) {
			
		}
		return "redirect:/ventapage/listvent";
	}
	
	@RequestMapping("/formvent/{codigo}")
	public String actualizvent (@PathVariable("codigo") Long codigo, Model mkkko) {
		mkkko.addAttribute("ventas", vsr.searchvent(codigo));
		mkkko.addAttribute("prosp", prsrv.listprod());
		mkkko.addAttribute("clpass", clsvr.listconjunt());
		mkkko.addAttribute("Regi3", "Editar Venta");
		return "ventaformulario";
	}
	
	@RequestMapping("/deletevent/{codigo}") 
	public String deletvent(@PathVariable("codigo") Long codigo) {
		vsr.deletevent(codigo);
		return "redirect:/ventapage/listvent";
	}
}
