package up.deconto.tf2.delivery.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import up.deconto.tf2.delivery.entities.EntregaEntity;

@Getter
@Setter
@NoArgsConstructor
public class EntregaDTO {
	
	private UUID id;
	private String destinatario;
	private String cpf;
	private String cep;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private float valor;
	private boolean entregue;
	private String entregador;
	
	public EntregaDTO(EntregaEntity entregaEntity) {
		id = entregaEntity.getId();
		destinatario = entregaEntity.getDestinatario();
		cpf = entregaEntity.getCpf();
		cep = entregaEntity.getCep();
		endereco = entregaEntity.getEndereco();
		numero = entregaEntity.getNumero();
		bairro = entregaEntity.getBairro();
		cidade = entregaEntity.getCidade();
		valor = entregaEntity.getValor();
		entregue = entregaEntity.isEntregue();
		entregador = entregaEntity.getEntregador();
	}
}
