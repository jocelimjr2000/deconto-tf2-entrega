package up.deconto.tf1.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.deconto.tf1.delivery.dto.EnderecoDTO;
import up.deconto.tf1.delivery.repositories.ViaCEPRepository;

@Service("addressService")
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private ViaCEPRepository addressInfoRepository;
	
	@Override
	public EnderecoDTO findAddressInfoByAreaCode(String cep) {
		return addressInfoRepository.findAddressInfoByAreaCode(cep);
	}

}
