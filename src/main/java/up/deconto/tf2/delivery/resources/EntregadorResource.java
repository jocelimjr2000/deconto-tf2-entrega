package up.deconto.tf2.delivery.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.deconto.tf2.delivery.services.EntregadorService;

@RestController
@RequestMapping("/entregador")
public class EntregadorResource {

	@Autowired
	EntregadorService entregadorService;
	
	@ApiOperation("Pesquisar entregador por id")
	@GetMapping
	public void find() {
		entregadorService.findById("626ea7ec509681fb83e86702");
	}
}
