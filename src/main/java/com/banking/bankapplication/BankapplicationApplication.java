package com.banking.bankapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.banking.bankapplication.repository")
@EntityScan("com.banking.bankapplication.model")
public class BankapplicationApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankapplicationApplication.class, args);
	}

}
