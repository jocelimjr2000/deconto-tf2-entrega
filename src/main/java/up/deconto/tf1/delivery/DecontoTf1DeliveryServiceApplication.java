package up.deconto.tf1.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
public class DecontoTf1DeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecontoTf1DeliveryServiceApplication.class, args);
	}

}
