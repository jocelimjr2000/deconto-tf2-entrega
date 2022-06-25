package up.deconto.tf2.delivery.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import up.deconto.tf2.delivery.dto.PagamentoDTO;

public interface PagamentoService {

	public void send(PagamentoDTO pagamentoDTO) throws JsonProcessingException;
}
