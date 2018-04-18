package com.springstarted.started;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StartedApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartedApplication.class, args);
	}
}
