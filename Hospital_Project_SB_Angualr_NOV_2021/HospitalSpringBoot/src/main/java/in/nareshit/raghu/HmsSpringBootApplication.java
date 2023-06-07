package in.nareshit.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@SpringBootApplication
public class HmsSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsSpringBootApplication.class, args);
	}

}
