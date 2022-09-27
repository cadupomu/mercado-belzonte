package com.rj.mercado.gestaoprodutos;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MercadoBelzonteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoBelzonteApplication.class, args);
	}

	@Bean
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(apiInfo());
	}

	private Info apiInfo() {
		return new Info()
				.title("Gestão de produtos")
				.description("Sistema que gere os produtos do supermercado Belzonte")
				.version("1.0.0");
	}
}
