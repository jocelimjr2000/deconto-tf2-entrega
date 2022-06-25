package up.deconto.tf2.delivery.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CadastrarEntregaDTO {
	
	@ApiModelProperty(value = "João da Silva", example = "João da Silva")
	@NotNull(message = "Preenchimento obrigatório")
	private String destinatario;
	
	@ApiModelProperty(value = "60162997078", example = "60162997078")
	@NotNull(message = "Preenchimento obrigatório")
	@CPF(message = "CPF Inválido")
	private String cpf;
	
	@ApiModelProperty(value = "81820020", example = "81820020")
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 8, max = 8, message = "CEP Inválido")
	private String cep;
	
	@ApiModelProperty(value = "123", example = "123")
	@NotNull(message = "Preenchimento obrigatório")
	private String numero;
	
	@ApiModelProperty(value = "10.23", example = "10.23")
	@NotNull(message = "Valor")
	private float valor;
	
}
