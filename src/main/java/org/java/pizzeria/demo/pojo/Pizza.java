package org.java.pizzeria.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pizza {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name can't be null")
	private String name;
	
	@NotBlank(message = "Description can't be null")
	private String description;
	
	@NotBlank(message = "Image can't be null")
	private String image;
	
	@Min(value = 0, message = "Price has to be from 0 to 1000 euro")
	@Max(value = 1000)
	private float price;
	
	public Pizza() {}
	
	public Pizza(String name, String description, String image, float price) {
		setName(name);
		setDescription(description);
		setImage(image);
		setPrice(price);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "]" + 
				getName() + ":" + getDescription() +
				"\nimmagine: " + getImage() + 
				"\nPrezzo: " + getPrice() + "E";
	}
	
	
	
}
