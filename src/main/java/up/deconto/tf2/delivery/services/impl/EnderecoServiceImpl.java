package up.deconto.tf2.delivery.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.deconto.tf2.delivery.dto.EnderecoDTO;
import up.deconto.tf2.delivery.repositories.ViaCEPRepository;
import up.deconto.tf2.delivery.services.EnderecoService;

@Service("addressService")
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private ViaCEPRepository addressInfoRepository;
	
	@Override
	public EnderecoDTO findAddressInfoByAreaCode(String cep) {
		return addressInfoRepository.findAddressInfoByAreaCode(cep);
	}

}
