package com.murat.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.murat")
@EntityScan(basePackages = "com.murat")
@EnableJpaRepositories(basePackages = "com.murat")
@SpringBootApplication
public class JpaDataBase01Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaDataBase01Application.class, args);
	}

}
