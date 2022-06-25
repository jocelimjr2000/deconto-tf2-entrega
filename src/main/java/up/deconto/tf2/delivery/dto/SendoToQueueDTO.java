package up.deconto.tf2.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendoToQueueDTO {

	private String id;
	private String pattern;
	private Object data;
	
}
