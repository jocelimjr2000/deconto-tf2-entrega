package up.deconto.tf2.delivery.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import up.deconto.tf2.delivery.services.EntregadorService;

@RestController
@RequestMapping("/entregador")
public class EntregadorResource {

	@Autowired
	EntregadorService entregadorService;
	
	@GetMapping
	public void test() {
		
		entregadorService.test();
	}
}
