package up.deconto.tf2.delivery.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import up.deconto.tf2.delivery.dto.PagamentoDTO;
import up.deconto.tf2.delivery.services.PagamentoService;

@Service("PagamentoService")
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {

	@Value("${topic.name.producer}")
	private String topicName;

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void send(PagamentoDTO pagamentoDTO) throws JsonProcessingException{

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(pagamentoDTO);
		
        kafkaTemplate.send(topicName, json);
    }

}
