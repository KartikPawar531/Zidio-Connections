package com.zidio_connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.zidio_connection.Entity")
@EnableJpaRepositories(basePackages = "com.zidio_connection.Repository")
@ComponentScan(basePackages = "com.zidio_connection")
@SpringBootApplication
public class ZidioConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZidioConnectionApplication.class, args);
	}
}
