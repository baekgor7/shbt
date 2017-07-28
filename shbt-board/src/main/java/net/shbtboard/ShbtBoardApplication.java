package net.shbtboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShbtBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShbtBoardApplication.class, args);
	}
}
