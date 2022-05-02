package com.perscholas.cafe3;

public class Coffee extends Product {
	private boolean sugar;
	private boolean milk;
	
	public Coffee() {
		super();
		this.milk = false;
		this.sugar = false;
	}
	
	public Coffee(String name, double price, String description, boolean milk, boolean sugar) {
		super(name, price, description);
		this.milk = milk;
		this.sugar = sugar;
		
	}
	
	public boolean getSugar() {
		return sugar;
	}
	
	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}
	
	public boolean getMilk() {
		return milk;
	}
	
	public void setMilk(boolean milk) {
		this.milk = milk;
	}
	
	@Override
	double calculateProductSubtotal() {
		double subtotal = this.getPrice() * this.getQuantity();
		double subtotalRound = Math.round(subtotal * 100.0) / 100.0;
		return subtotalRound;
	}

	@Override
	void addOptions(String a, String b) {
		if(a.equals("y")) {
			this.milk = true;
		}
		if(b.equals("y")) {
			this.sugar = true;
		}
	}

	@Override
	void printOptions() {
		// TODO Auto-generated method stub
		if (milk && sugar) {
			System.out.println("Milk: Yes    Sugar: Yes");
		} else if (!milk && !sugar) {
			System.out.println("Milk: No    Sugar: No");
		} else if (!milk && sugar) {
			System.out.println("Milk: No    Sugar: Yes");
		} else {
			System.out.println("Milk: Yes    Sugar: No");
		}
		
	}



}
