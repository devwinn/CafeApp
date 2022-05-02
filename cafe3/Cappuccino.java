package com.perscholas.cafe3;

public class Cappuccino extends Product {
	
	private boolean whippedCream;
	private boolean peppermint;

	final double pepPrice = 2.00;
	final double whipPrice = 1.00;
	private int pepQuantity;
	private int whipQuantity;
	
	public Cappuccino() {
		super();
		this.peppermint = false;
		this.whippedCream = false;
	}
	
	public Cappuccino(String name, double price, String description, boolean pep, boolean whip) {
		super(name, price, description);
		this.peppermint = pep;
		this.whippedCream = whip;
	}
	
	public boolean getPep() {
		return peppermint;
	}
	
	public void setPep(boolean pep) {
		this.peppermint = pep;
	}
	
	public boolean getWhip() {
		return whippedCream;
	}
	
	public void setWhip(boolean whip) {
		this.whippedCream = whip;
	}
	
	public int getPQuant() {
		return pepQuantity;
	}
	
	public void setPQuant(int quantity) {
		this.pepQuantity = quantity;
	}
	
	public int getWQuant() {
		return whipQuantity ;
	}
	
	public void setWQuant(int quantity) {
		this.whipQuantity = quantity;
	}
	
	public double extraSubtotal() {
		
		if (this.getPep() && this.getWhip()) {
			double sub = (this.getQuantity() * pepPrice) + (this.getQuantity() * whipPrice);
			return (Math.round(sub * 100.0) / 100.0);
		} else if (this.getPep() && !this.getWhip()) {
			double sub = (this.getQuantity() * pepPrice);
			return (Math.round(sub * 100.0) / 100.0);
		} else if (!this.getPep() && this.getWhip()) {
			double sub = (this.getQuantity() * whipPrice);
			return (Math.round(sub * 100.0) / 100.0);
		} else {
			return 0;
		}
	}
	
	@Override
	double calculateProductSubtotal() {
		double subtotal = (this.getPrice() * this.getQuantity()) + this.extraSubtotal();
		double subtotalRound = Math.round(subtotal * 100.0) / 100.0;
		return subtotalRound;
	}

	@Override
	void addOptions(String a, String b) {
		if(a.equals("y")) {
			this.setPep(true);
		}
		
		if(b.equals("y")) {
			this.setWhip(true);
		}
	}

	@Override
	void printOptions() {
		if (peppermint && whippedCream) {
			System.out.println("Peppermint: Yes    Whipped Cream: Yes");
		} else if (!peppermint && !whippedCream) {
			System.out.println("Peppermint: No    Whipped Cream: No");
		} else if (!peppermint && whippedCream) {
			System.out.println("Peppermint: No    Whipped Cream: Yes");
		} else {
			System.out.println("Peppermint: Yes    Whipped Cream: No");
		}
		
	}


}