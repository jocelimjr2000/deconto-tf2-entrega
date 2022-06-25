package up.deconto.tf2.delivery.services.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
	public EntregadorDTO findById(String id) {
		
		String correlationId = "entregador_id_" + id;
		
		EntregadorDTO entregadorDTO = new EntregadorDTO();
		entregadorDTO.setId(id);
		
		SendoToQueueDTO sendoToQueueDTO = new SendoToQueueDTO();
		sendoToQueueDTO.setId(correlationId);
		sendoToQueueDTO.setPattern("find-entregador");
		sendoToQueueDTO.setData(entregadorDTO);
		
		Object receive = amqpTemplate.convertSendAndReceive(RabbitMQConstants.QUEUE, sendoToQueueDTO, m -> {
//		    m.getMessageProperties().setPriority(1);        
			m.getMessageProperties().setReplyTo(RabbitMQConstants.QUEUE_REPLY);
			m.getMessageProperties().setCorrelationId(correlationId);
		    return m;
		});
		
		System.out.println(receive);
		
		// TODO Auto-generated method stub
		return null;
	}


}
