package com.perscholas.cafe3;

public class Espresso extends Product {

	private boolean extraShot;
	private boolean macchiato;
	final double shotPrice = 2.00;
	final double macchiatoPrice = 1.00;
	private int shotQuantity;
	private int macchiatoQuantity;
	
	public Espresso() {
		super();
		this.extraShot = false;
		this.macchiato = false;
	}
	
	public Espresso(String name, double price, String description, boolean extraShot, boolean macchiato) {
		super(name, price, description);
		this.extraShot = extraShot;
		this.macchiato = macchiato;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}
	
	public boolean getMacchiato() {
		return macchiato;
	}
	
	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}
	
	public int getMQuant() {
		return macchiatoQuantity;
	}
	
	public void setMQuant(int quantity) {
		this.macchiatoQuantity += quantity;
	}
	
	public int getSQuant() {
		return shotQuantity;
	}
	
	public void setSQuant(int quantity) {
		this.shotQuantity += quantity;
	}
	
	public double extraSubtotal() {
		if (this.getMacchiato() && this.getExtraShot()) {
			double sub = (this.getQuantity() * shotPrice) + (this.getQuantity() * macchiatoPrice);
			return (Math.round(sub * 100.0) / 100.0);
		} else if (this.getMacchiato() && !this.getExtraShot()) {
			double sub = (this.getQuantity() * macchiatoPrice);
			return (Math.round(sub * 100.0) / 100.0);
		} else if (!this.getMacchiato() && this.getExtraShot()) {
			double sub = (this.getQuantity() * shotPrice);
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
			this.setExtraShot(true);
		}
		if(b.equals("y")) {
			this.setMacchiato(true);
		}
	}

	@Override
	void printOptions() {
		if (extraShot && macchiato) {
			System.out.println("Extra Shot: Yes    Macchiato: Yes");
		} else if (!extraShot && !macchiato) {
			System.out.println("Extra Shot: No    Macchiato: No");
		} else if (!extraShot && macchiato) {
			System.out.println("Extra Shot: No    Macchiato: Yes");
		} else {
			System.out.println("Extra Shot: Yes    Macchiato: No");
		}
		
	}


}
