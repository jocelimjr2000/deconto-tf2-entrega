package up.deconto.tf2.delivery.services;

import up.deconto.tf2.delivery.dto.EnderecoDTO;

public interface EnderecoService {

	EnderecoDTO findAddressInfoByAreaCode(String cep);
}
