package com.hogwai.reactivewebapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;


@EnableWebFlux
@EnableR2dbcRepositories
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Post API", version = "1.0", description = "Post API Documentation"))
public class ReactiveWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebAppApplication.class, args);
	}

}
