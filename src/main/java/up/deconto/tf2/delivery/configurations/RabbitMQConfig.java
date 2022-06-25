package up.deconto.tf2.delivery.configurations;

import org.springframework.amqp.core.Declarables;
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
		return new Declarables(
			new Queue(RabbitMQConstants.QUEUE, true, false, false),
			new Queue(RabbitMQConstants.QUEUE_REPLY, true, false, false)
		);
	}
	
	@Bean
	public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper mapper) {
	    final var jsonRabbitTemplate = new RabbitTemplate(connectionFactory);
	    jsonRabbitTemplate.setReplyAddress(RabbitMQConstants.QUEUE_REPLY);
//	    jsonRabbitTemplate.setReplyTimeout(6000000);
    	jsonRabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(mapper));
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
