package org.java.pizzeria.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.java.pizzeria.demo.pojo.Ingredienti;
import org.java.pizzeria.demo.pojo.OffertaSpeciale;
import org.java.pizzeria.demo.pojo.Pizza;
import org.java.pizzeria.demo.serv.IngredientiService;
import org.java.pizzeria.demo.serv.OffertaService;
import org.java.pizzeria.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService pizzaservice;
	
	@Autowired
	private OffertaService offertaservice;
	
	@Autowired
	private IngredientiService ingredientiservice;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ingredienti ing1 = new Ingredienti("mozzarella");
		Ingredienti ing2 = new Ingredienti("pomodori");
		Ingredienti ing3 = new Ingredienti("acciughe");
		
		ingredientiservice.save(ing1);
		ingredientiservice.save(ing2);
		ingredientiservice.save(ing3);
		
		
		
		Pizza margherita = new Pizza("margherita", "descrizione pizza", "https://static.cookist.it/wp-content/uploads/sites/21/2018/04/pizza-margherita-fatta-in-casa.jpg", 10.00f);
		Pizza marinara = new Pizza("marinara", "descrizione pizza marinara", "https://static.cookist.it/wp-content/uploads/sites/21/2018/04/pizza-margherita-fatta-in-casa.jpg", 8.00f);
		
		pizzaservice.save(margherita);
		pizzaservice.save(marinara);
		
		OffertaSpeciale off1 = new OffertaSpeciale(LocalDate.parse("2023-05-28"), LocalDate.parse("2023-05-31"), "Nuova offerta", 20, margherita);		
		OffertaSpeciale off2 = new OffertaSpeciale(LocalDate.parse("2023-06-10"), LocalDate.parse("2023-06-30"), "Seconda offerta", 15, marinara);
		OffertaSpeciale off3 = new OffertaSpeciale(LocalDate.parse("2023-05-01"), LocalDate.parse("2023-05-15"), "Pizza special", 10, margherita);
		OffertaSpeciale off4 = new OffertaSpeciale(LocalDate.parse("2023-06-28"), LocalDate.parse("2023-06-02"), "Promo", 30, marinara);
		
		offertaservice.save(off1);
		offertaservice.save(off2);
		offertaservice.save(off3);
		offertaservice.save(off4);
		
		List<Pizza> pizze = pizzaservice.findAll();
		
		for(Pizza pizza : pizze) {

			Optional<Pizza> optPizzaOffer = pizzaservice.findByIdWithOffertaSpeciale(pizza.getId());
			Pizza pizzaOffer = optPizzaOffer.get();
			System.out.println(pizzaOffer.getOfferte());

		}
		
		System.out.println(pizze);
		
	}

}
