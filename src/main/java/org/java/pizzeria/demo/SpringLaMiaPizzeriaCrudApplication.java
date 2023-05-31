package org.java.pizzeria.demo;

import java.util.List;

import org.java.pizzeria.demo.pojo.Pizza;
import org.java.pizzeria.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaservice;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pizza margherita = new Pizza("margherita", "descrizione pizza", "https://static.cookist.it/wp-content/uploads/sites/21/2018/04/pizza-margherita-fatta-in-casa.jpg", 10.00f);
		Pizza marinara = new Pizza("marinara", "descrizione pizza marinara", "https://static.cookist.it/wp-content/uploads/sites/21/2018/04/pizza-margherita-fatta-in-casa.jpg", 8.00f);
		
		
		pizzaservice.save(margherita);
		pizzaservice.save(marinara);
		
		List<Pizza> pizze = pizzaservice.findAll();
		System.out.println(pizze);
		
	}

}
