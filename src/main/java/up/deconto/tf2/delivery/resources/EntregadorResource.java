package up.deconto.tf2.delivery.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.deconto.tf2.delivery.dto.EntregadorDTO;
import up.deconto.tf2.delivery.services.EntregadorService;

@RestController
@RequestMapping("/entregador")
public class EntregadorResource {

	@Autowired
	EntregadorService entregadorService;
	
	@ApiOperation("Pesquisar entregador por id")
	@GetMapping("/{id}")
	public ResponseEntity<EntregadorDTO> find(@PathVariable("id") String id) {
		EntregadorDTO entregadorDTO = entregadorService.findById(id);
		
		return new ResponseEntity<>(entregadorDTO, HttpStatus.OK);
	}
}
