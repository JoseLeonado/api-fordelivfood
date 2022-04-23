package com.jlcb.fordelivfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jlcb.fordelivfood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class ApiFordelivfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFordelivfoodApplication.class, args);
	}

}