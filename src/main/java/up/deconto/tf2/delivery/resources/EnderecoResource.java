package up.deconto.tf2.delivery.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.deconto.tf2.delivery.dto.EnderecoDTO;
import up.deconto.tf2.delivery.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService addressService;
	
	@ApiOperation("Buscar dados do endereço por CEP")
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoDTO> findAddressInfo(@PathVariable(value = "cep") String cep){

		EnderecoDTO enderecoDTO = addressService.findAddressInfoByAreaCode(cep);
		
		return new ResponseEntity<>(enderecoDTO, HttpStatus.OK); 
	}
}
