package up.deconto.tf1.delivery.services;

import up.deconto.tf1.delivery.dto.EnderecoDTO;

public interface EnderecoService {

	EnderecoDTO findAddressInfoByAreaCode(String cep);
}
