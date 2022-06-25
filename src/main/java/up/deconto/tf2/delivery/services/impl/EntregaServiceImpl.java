package up.deconto.tf2.delivery.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.deconto.tf2.delivery.dto.AtualizarEntregaDTO;
import up.deconto.tf2.delivery.dto.CadastrarEntregaDTO;
import up.deconto.tf2.delivery.dto.EnderecoDTO;
import up.deconto.tf2.delivery.dto.EntregaDTO;
import up.deconto.tf2.delivery.dto.IncluirEntregadorDTO;
import up.deconto.tf2.delivery.entities.EntregaEntity;
import up.deconto.tf2.delivery.repositories.EntregaRepository;
import up.deconto.tf2.delivery.services.EnderecoService;
import up.deconto.tf2.delivery.services.EntregaService;

@Service("entregaService")
public class EntregaServiceImpl implements EntregaService {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	EntregaRepository entregaRepository;
	
	@Override
	public EntregaDTO create(CadastrarEntregaDTO cadastrarEntregaDTO) {
		
		EnderecoDTO enderecoDTO = enderecoService.findAddressInfoByAreaCode(cadastrarEntregaDTO.getCep());
		
		EntregaEntity entregaEntity = new EntregaEntity();
		entregaEntity.setDestinatario(cadastrarEntregaDTO.getDestinatario());
		entregaEntity.setCpf(cadastrarEntregaDTO.getCpf());
		entregaEntity.setCep(enderecoDTO.getCep());
		entregaEntity.setEndereco(enderecoDTO.getLogradouro());
		entregaEntity.setNumero(cadastrarEntregaDTO.getNumero());
		entregaEntity.setBairro(enderecoDTO.getBairro());
		entregaEntity.setCidade(enderecoDTO.getLocalidade());
		entregaEntity.setValor(cadastrarEntregaDTO.getValor());
		
		entregaEntity = entregaRepository.save(entregaEntity);
		
		return new EntregaDTO(entregaEntity);
	}

	@Override
	public void delete(UUID id) {
		entregaRepository.deleteById(id);
	}
	
	@Override
	public EntregaDTO findById(UUID id) {
		Optional<EntregaEntity> entregaEntity = entregaRepository.findById(id);
		
		if(entregaEntity.isEmpty() == false) {
			return new EntregaDTO(entregaEntity.get());
		}
		
		return null;
	}
	
	@Override
	public List<EntregaDTO> findAll() {
		List<EntregaDTO> listEntrega = new ArrayList<>();
		
		for (EntregaEntity entregaEntity : entregaRepository.findAll()) {
			listEntrega.add(new EntregaDTO(entregaEntity));
		}
		
		return listEntrega;
	}

	@Override
	public EntregaDTO update(AtualizarEntregaDTO atualizarEntregaDTO) {
		Optional<EntregaEntity> entregaEntityOp = entregaRepository.findById(atualizarEntregaDTO.getId());
		
		if(entregaEntityOp.isEmpty() == false) {
			EntregaEntity entregaEntity = entregaEntityOp.get();
			
			if(atualizarEntregaDTO.getCep().equals(entregaEntity.getCep()) == false) {
				EnderecoDTO enderecoDTO = enderecoService.findAddressInfoByAreaCode(atualizarEntregaDTO.getCep());
				
				entregaEntity.setCep(enderecoDTO.getCep());
				entregaEntity.setEndereco(enderecoDTO.getLogradouro());
				entregaEntity.setBairro(enderecoDTO.getBairro());
				entregaEntity.setCidade(enderecoDTO.getLocalidade());
			}
			
			entregaEntity.setDestinatario(atualizarEntregaDTO.getDestinatario());
			entregaEntity.setCpf(atualizarEntregaDTO.getCpf());
			entregaEntity.setNumero(atualizarEntregaDTO.getNumero());
			entregaEntity.setValor(atualizarEntregaDTO.getValor());
			
			entregaEntity = entregaRepository.save(entregaEntity);
			
			return new EntregaDTO(entregaEntity);
		}
		
		return null;
	}

	@Override
	public EntregaDTO updateBoy(IncluirEntregadorDTO incluirEntregadorDTO) {
		Optional<EntregaEntity> entregaEntityOp = entregaRepository.findById(incluirEntregadorDTO.getId());
		
		if(entregaEntityOp.isEmpty() == false) {
			EntregaEntity entregaEntity = entregaEntityOp.get();
			
			entregaEntity.setEntregador(incluirEntregadorDTO.getEntregador());
			
			entregaEntity = entregaRepository.save(entregaEntity);
			
			return new EntregaDTO(entregaEntity);
		}
		
		return null;
	}

	@Override
	public EntregaDTO finish(UUID id) {
		Optional<EntregaEntity> entregaEntityOp = entregaRepository.findById(id);
		
		if(entregaEntityOp.isEmpty() == false) {
			EntregaEntity entregaEntity = entregaEntityOp.get();
			
			entregaEntity.setEntregue(true);
			
			entregaEntity = entregaRepository.save(entregaEntity);
			
			return new EntregaDTO(entregaEntity);
		}
		
		return null;
	}
	
}
