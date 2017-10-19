package com.target;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.target.entity.Conta;
import com.target.repository.ContaRepository;

@SpringBootApplication
public class TargetCompletoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetCompletoApplication.class, args);
	}
	
	@Bean
        CommandLineRunner demo(ContaRepository contaRepository) {
                return args -> Stream.of("Alex", "Joao", "Maria", "Jose", "Bill Gates")
                .map(name -> new Conta(name, randomBalance()))
                .map(conta -> contaRepository.save(conta))
                .forEach(System.out::println);
}

  private Double randomBalance() {
    return Math.random()*100;
  }
}
