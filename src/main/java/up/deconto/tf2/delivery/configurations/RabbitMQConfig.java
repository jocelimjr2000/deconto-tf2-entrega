package up.deconto.tf2.delivery.configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import up.deconto.tf2.delivery.constants.RabbitMQConstants;

@Configuration
public class RabbitMQConfig {

	@Bean
	Declarables qs() {

		Map<String, Object> argumentsPatients = new HashMap<String, Object>();
		argumentsPatients.put("x-dead-letter-exchange", RabbitMQConstants.EXCHANGE_DEAD);
		argumentsPatients.put("x-dead-letter-routing-key", RabbitMQConstants.ROUTING_KEY_DEAD);

		return new Declarables(
			new Queue(RabbitMQConstants.QUEUE, true, false, false),
			new Queue(RabbitMQConstants.QUEUE_REPLY, true, false, false)
				
//			new DirectExchange(RabbitMQConstants.EXCHANGE, true, false),
//			new DirectExchange(RabbitMQConstants.EXCHANGE_DEAD),
//			new Queue(RabbitMQConstants.QUEUE_DEAD, true),
//			new Queue(RabbitMQConstants.QUEUE, true, false, false, argumentsPatients),
//			new Binding(RabbitMQConstants.QUEUE_DEAD, DestinationType.QUEUE, RabbitMQConstants.EXCHANGE_DEAD, RabbitMQConstants.ROUTING_KEY_DEAD, null),
//			new Binding(RabbitMQConstants.QUEUE, DestinationType.QUEUE, RabbitMQConstants.EXCHANGE, RabbitMQConstants.ROUTING_KEY, null)
		);
	}
	
	@Bean
	public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper mapper) {
	    final var jsonRabbitTemplate = new RabbitTemplate(connectionFactory);
	    jsonRabbitTemplate.setReplyAddress(RabbitMQConstants.QUEUE_REPLY);
//	    jsonRabbitTemplate.setReplyTimeout(6000000);
	    if(mapper != null) {
	    	jsonRabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(mapper));
	    }
	    return jsonRabbitTemplate;
	}
	
	 @Bean
	    SimpleMessageListenerContainer replyContainer(ConnectionFactory connectionFactory, ObjectMapper mapper) {

	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory);
	        container.setQueueNames(RabbitMQConstants.QUEUE_REPLY);
	        container.setMessageListener(jsonRabbitTemplate(connectionFactory, mapper));
	        return container;
	    }
	 
}
