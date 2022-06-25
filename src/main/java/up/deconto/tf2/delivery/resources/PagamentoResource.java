package up.deconto.tf2.delivery.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import up.deconto.tf2.delivery.dto.PagamentoDTO;
import up.deconto.tf2.delivery.services.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoResource {

	@Autowired
	PagamentoService pagamentoService;

	@GetMapping
	public void test() {
		PagamentoDTO pagamentoDTO = new PagamentoDTO();
		pagamentoDTO.setIdEntregal("aa");
		pagamentoDTO.setValor((float) 10.0);
		
		try {
			pagamentoService.send(pagamentoDTO);
		} catch (JsonProcessingException e) {}
	}

}
