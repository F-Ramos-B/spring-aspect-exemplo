package br.com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.annotation.copy.CalculadorPreco;
import br.com.annotation.copy.Produto;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	CalculadorPreco calculador;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("\n\n");

		Produto produto = new Produto("TV", 1900.00, 15, 3);
		calculador.somarValor(produto);
		System.out.println(produto.getStatus());
	}

}
