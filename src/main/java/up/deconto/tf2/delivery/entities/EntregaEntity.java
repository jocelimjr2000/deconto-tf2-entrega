package up.deconto.tf2.delivery.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="id", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	@Type(type = "uuid-char")
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
	
	@Column(nullable = false)
	private float valor;
	
	private boolean entregue = false;
	
	private String entregador;
}
