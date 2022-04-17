package up.deconto.tf1.delivery.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Entrega")
public class EntregaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", insertable = false, updatable = false, nullable = false)
	private UUID id;
	
	@Column(nullable = false)
	private String destinatario;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String endereco;
	
	private String numero;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	private boolean entregue = false;
	
	private String entregador;
}
