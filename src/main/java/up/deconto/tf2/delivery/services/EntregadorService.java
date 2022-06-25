package up.deconto.tf2.delivery.services;

import java.util.UUID;

import up.deconto.tf2.delivery.dto.EntregadorDTO;

public interface EntregadorService {

	public EntregadorDTO findById(UUID id);
	
	public EntregadorDTO test();
}
