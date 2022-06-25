package up.deconto.tf2.delivery.services.impl;

import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import up.deconto.tf2.delivery.constants.RabbitMQConstants;
import up.deconto.tf2.delivery.dto.EntregadorDTO;
import up.deconto.tf2.delivery.dto.SendoToQueueDTO;
import up.deconto.tf2.delivery.services.EntregadorService;

@Service("entregadorService")
public class EntregadorServiceImpl implements EntregadorService {
	
	@Autowired
    private AmqpTemplate amqpTemplate;
	
	@Override
	public EntregadorDTO findById(UUID id) {
		
		amqpTemplate.convertSendAndReceive(RabbitMQConstants.EXCHANGE, RabbitMQConstants.ROUTING_KEY, id, m -> {
		    m.getMessageProperties().setPriority(1);        
		    return m;
		});
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public EntregadorDTO test() {
		
		EntregadorDTO entregadorDTO = new EntregadorDTO();
		entregadorDTO.setId("vindo do java");
		
		SendoToQueueDTO sendoToQueueDTO = new SendoToQueueDTO();
		sendoToQueueDTO.setId("teste");
		sendoToQueueDTO.setPattern("execute");
		sendoToQueueDTO.setData(entregadorDTO);
		
		Object receive = amqpTemplate.convertSendAndReceive(RabbitMQConstants.QUEUE, sendoToQueueDTO, m -> {
//		    m.getMessageProperties().setPriority(1);        
			m.getMessageProperties().setReplyTo(RabbitMQConstants.QUEUE_REPLY);
			m.getMessageProperties().setCorrelationId("teste");
		    return m;
		});
		
		System.out.println(receive);
		
		// TODO Auto-generated method stub
		return null;
	}


}
