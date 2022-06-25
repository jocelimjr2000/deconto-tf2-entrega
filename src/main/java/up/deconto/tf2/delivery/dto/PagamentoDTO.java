package up.deconto.tf2.delivery.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import up.deconto.tf2.delivery.validators.CheckEntrega;
import up.deconto.tf2.delivery.validators.IsUUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

	@NotNull(message = "Preenchimento obrigatório")
	@IsUUID(message = "UUID Inválido")
	@CheckEntrega
	private String idEntrega;
	
	@NotNull(message = "Preenchimento obrigatório")
	private float valor;
}
