package up.deconto.tf2.delivery.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import up.deconto.tf2.delivery.validators.CheckEntregador;
import up.deconto.tf2.delivery.validators.IsUUID;

@Getter
@Setter
@NoArgsConstructor
public class IncluirEntregadorDTO {
	
	@ApiModelProperty(value = "3fa85f64-5717-4562-b3fc-2c963f66afa6", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
	@NotNull(message = "Preenchimento obrigatório")
	@IsUUID(message = "UUID Inválido")
	private String id;
	
	@ApiModelProperty(value = "3fa85f64-5717-4562-b3fc-2c963f66afa6", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
	@NotNull(message = "Preenchimento obrigatório")
	@CheckEntregador
	private String entregador;
	
	public UUID getId() {
		return UUID.fromString(id);
	}	
}
