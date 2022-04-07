package up.deconto.tf1.delivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO {
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	
	public String getCep() {
		return cep.replaceAll("[^0-9?!\\.]","");
	}
}
