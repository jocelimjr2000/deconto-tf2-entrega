package up.deconto.tf2.delivery.constants;

public final class RabbitMQConstants {

	public static final String EXCHANGE = "sistema";
	public static final String EXCHANGE_DEAD = "sistema.dead";
	
	public static final String QUEUE = "entregadores";
	public static final String QUEUE_REPLY = "entregadores.reply";
	public static final String QUEUE_DEAD = "entregadores.dead";
	
	public static final String ROUTING_KEY = "entregador";
	public static final String ROUTING_KEY_DEAD = "entregador.dead";
	
}
