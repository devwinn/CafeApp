package com.perscholas.cafe3;

abstract class Product {
	private String name;
	private double price;
	private String description;
	private int quantity;
	private double salesTax = 0.08;
	
	public Product () {}
	
	public Product(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	abstract double calculateProductSubtotal();
	
	abstract void addOptions(String a, String b);
	
	abstract void printOptions();
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	
	
	public double productSalesTax() {
		double tax = this.calculateProductSubtotal() * salesTax;
		double taxRound = Math.round(tax * 100.0) / 100.0;
		return taxRound;
	}
	

}
