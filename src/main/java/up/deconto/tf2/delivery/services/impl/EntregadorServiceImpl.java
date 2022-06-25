package up.deconto.tf2.delivery.services.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import up.deconto.tf2.delivery.constants.RabbitMQConstants;
import up.deconto.tf2.delivery.dto.EntregadorDTO;
import up.deconto.tf2.delivery.dto.SendoToQueueDTO;
import up.deconto.tf2.delivery.services.EntregadorService;

@Service("entregadorService")
public class EntregadorServiceImpl implements EntregadorService {
	
	@Autowired
    private AmqpTemplate amqpTemplate;
	
	@Override
	public EntregadorDTO findById(String id) {
		
		String correlationId = "entregador_id_" + id;
		
		EntregadorDTO sendEntregadorDTO = new EntregadorDTO();
		sendEntregadorDTO.setId(id);
		
		SendoToQueueDTO sendoToQueueDTO = new SendoToQueueDTO();
		sendoToQueueDTO.setId(correlationId);
		sendoToQueueDTO.setPattern("find-entregador");
		sendoToQueueDTO.setData(sendEntregadorDTO);
		
		MessagePostProcessor messagePostProcessor = message -> {
			MessageProperties messageProperties = message.getMessageProperties();
			messageProperties.setReplyTo(RabbitMQConstants.QUEUE_REPLY);
			messageProperties.setCorrelationId(correlationId);
			messageProperties.setContentType("application/json");
			return message;
	    };
		
		Object receive = amqpTemplate.convertSendAndReceive(RabbitMQConstants.QUEUE, sendoToQueueDTO, messagePostProcessor);
		
		String payload = null;
		
		try {
			payload = new ObjectMapper().writeValueAsString(receive);
		} catch (JsonProcessingException e) {}
		
		if(payload == null) {
			return null;
		}
		
		EntregadorDTO entregadorDTO = null;
		
		JsonObject jsonObject = JsonParser.parseString(payload).getAsJsonObject();
		
		boolean response = jsonObject.get("response").isJsonNull();
		
		if(response == false) {
			
			JsonObject responseObj = jsonObject.get("response").getAsJsonObject();
			
			entregadorDTO = new EntregadorDTO();
			
			String getId = null;
			String getName = null;
			
			try {
				getId = responseObj.get("id").getAsString();
			}catch (Exception e) {}
			
			try {
				getName = responseObj.get("nome").getAsString();
			}catch (Exception e) {}
			
			entregadorDTO.setId(getId);
			entregadorDTO.setNome(getName);
		}

		return entregadorDTO;
	}


}
