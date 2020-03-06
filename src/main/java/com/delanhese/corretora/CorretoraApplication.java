package com.delanhese.corretora;

import com.delanhese.corretora.configs.ConfigurationCors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CorretoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorretoraApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/setor").allowedOrigins("http://localhost:8080");
			}
		};
	}

}
