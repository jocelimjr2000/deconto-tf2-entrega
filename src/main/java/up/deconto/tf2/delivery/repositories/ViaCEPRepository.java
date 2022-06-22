package up.deconto.tf2.delivery.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import up.deconto.tf2.delivery.dto.EnderecoDTO;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCEPRepository {

	@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
	EnderecoDTO findAddressInfoByAreaCode(@RequestParam(value = "cep") String cep);
	
}
