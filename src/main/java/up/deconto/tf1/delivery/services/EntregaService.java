package up.deconto.tf1.delivery.services;

import java.util.List;
import java.util.UUID;

import up.deconto.tf1.delivery.dto.AtualizarEntregaDTO;
import up.deconto.tf1.delivery.dto.CadastrarEntregaDTO;
import up.deconto.tf1.delivery.dto.EntregaDTO;
import up.deconto.tf1.delivery.dto.IncluirEntregadorDTO;

public interface EntregaService {

	EntregaDTO create(CadastrarEntregaDTO cadastrarEntregaDTO);
	EntregaDTO update(AtualizarEntregaDTO atualizarEntregaDTO);
	EntregaDTO updateBoy(IncluirEntregadorDTO incluirEntregadorDTO);
	EntregaDTO finish(UUID id);
	List<EntregaDTO> findAll();
	EntregaDTO findById(UUID id);
	void delete(UUID id);
}
