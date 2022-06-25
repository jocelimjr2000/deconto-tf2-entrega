package up.deconto.tf2.delivery.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public void payment(@Valid @RequestBody PagamentoDTO pagamentoDTO) {
		try {
			pagamentoService.send(pagamentoDTO);
		} catch (JsonProcessingException e) {}
	}

}
