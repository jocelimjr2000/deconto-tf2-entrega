package up.deconto.tf2.delivery.resources;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.deconto.tf2.delivery.dto.AtualizarEntregaDTO;
import up.deconto.tf2.delivery.dto.CadastrarEntregaDTO;
import up.deconto.tf2.delivery.dto.EntregaDTO;
import up.deconto.tf2.delivery.dto.IncluirEntregadorDTO;
import up.deconto.tf2.delivery.services.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaResource {
	
	@Autowired
	EntregaService entregaService;
	
	@ApiOperation("Cadastrar entrega")
	@PostMapping
	public ResponseEntity<EntregaDTO> create(@Valid @RequestBody CadastrarEntregaDTO cadastrarEntregaDTO) {
		
		EntregaDTO entregaDTO = entregaService.create(cadastrarEntregaDTO);
		
		return new ResponseEntity<>(entregaDTO, HttpStatus.OK);
	}
	
	@ApiOperation("Listar entregas")
	@GetMapping
	public ResponseEntity<List<EntregaDTO>> findAll(){
		return new ResponseEntity<>(entregaService.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation("Pesquisar entrega por id")
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> findById(@Valid @PathVariable(value = "id") UUID id){
		return new ResponseEntity<>(entregaService.findById(id), HttpStatus.OK);
	}
	
	@ApiOperation("Atualizar entrega")
	@PutMapping
	public ResponseEntity<EntregaDTO> update(@Valid @RequestBody AtualizarEntregaDTO atualizarEntregaDTO) {
		
		EntregaDTO entregaDTO = entregaService.update(atualizarEntregaDTO);
		
		return new ResponseEntity<>(entregaDTO, HttpStatus.OK);
	}
	
	@ApiOperation("Deletar entrega")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@Valid @PathVariable(value = "id") UUID id) {
		
		entregaService.delete(id);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@ApiOperation("Incluir entregador")
	@PutMapping("/entregador")
	public ResponseEntity<EntregaDTO> updatePerson(@Valid @RequestBody IncluirEntregadorDTO incluirEntregadorDTO) {
		
		EntregaDTO entregaDTO = entregaService.updateBoy(incluirEntregadorDTO);
		
		return new ResponseEntity<>(entregaDTO, HttpStatus.OK);
	}
	
	@ApiOperation("Concluir entrega")
	@PutMapping("/concluir/{id}")
	public ResponseEntity<EntregaDTO> finish(@Valid @PathVariable(value = "id") UUID id) {
		
		EntregaDTO entregaDTO = entregaService.finish(id);
		
		return new ResponseEntity<>(entregaDTO, HttpStatus.OK);
	}
	
}
