package org.java.pizzeria.demo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OffertaSpeciale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private String titolo;
	private double sconto;
	
	
	@ManyToOne
	@JoinColumn( name = "pizza_id", nullable = false)
	private Pizza pizza;
	
	public OffertaSpeciale() {
		
	}
	public OffertaSpeciale(LocalDate dataInizio, LocalDate dataFine,String titolo,double sconto, Pizza pizza) {
		setDataInizio(dataInizio);
		setDataFine(dataFine);
		setTitolo(titolo);
		setSconto(sconto);
		setPizza(pizza);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public double getSconto() {
		return sconto;
	}
	public void setSconto(double sconto) {
		this.sconto = sconto;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String toString() {
		return getTitolo() + 
			  "Data inizio: " + getDataInizio() +
			  "Data fine: " + getDataFine() +
			  "Sconto: " + getSconto();
				
	}
	
	

}
