package com.delanhese.corretora;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.delanhese.corretora.model.Setor;
import com.delanhese.corretora.repository.SetorRepository;

@SpringBootApplication
public class CorretoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorretoraApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(SetorRepository repository) {
		repository.deleteAll();
		repository.save(new Setor(null,"Híbrido"));
		repository.save(new Setor(null, "Papel"));
		return null;
        
    }
	
}
