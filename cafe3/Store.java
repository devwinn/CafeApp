package com.perscholas.cafe3;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
	
	static ArrayList<Product> orderItems = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);

	//add menu function
	public static void menu() {
		
		System.out.println("Please select from the following menu");
		System.out.println("1: Coffee $2.99");
		System.out.println("2: Cappuccino $4.79");
		System.out.println("3: Espresso $3.50");
		System.out.println("4: Checkout");			
	}
	
	public static void selection() {
		int selection = 0;
		
		//String selectYorN;
		while (selection!= -1) {
			selection = 0;	
			Store.menu();
			selection = scan.nextInt();
			
			if (selection == 1) {
				Store.newCoffee();
				System.out.println("Anything else? (y/n)");
				String selectYorN = scan.next();
				if(selectYorN.equals("n")) {
						selection = -1;
				} else {
					System.out.println("");
					continue;
				}
			} else if (selection == 3) {
				Store.newEspresso();
				System.out.println("Anything else? (y/n)");
				String selectYorN = scan.next();
				if(selectYorN.equals("n")) {
						selection = -1;
				} else {
					System.out.println("");
					continue;
				}
			} else if (selection == 2) {
				Store.newCappuccino();
				System.out.println("Anything else? (y/n)");
				String selectYorN = scan.next();
				if(selectYorN.equals("n")) {
						selection = -1;
				} else {
					System.out.println("");
					continue;
				}
			} else if (selection == 4) {
				System.out.println("Proceed to checkout.");
				selection = -1;	
			}
		
		}
	}
	
	public static void newCoffee(){
		Coffee coffee = new Coffee("Coffee", 2.99, "Dark Roast", false, false);

		System.out.println("\nHow many coffees would you like?");
		int coffeeQuantity = scan.nextInt();
		coffee.setQuantity(coffeeQuantity);
		System.out.println("Milk (y/n)");
		String milk = scan.next();
		System.out.println("Sugar (y/n)");
		String sugar = scan.next();
		coffee.addOptions(milk, sugar);
		orderItems.add(coffee);
	}
	
	public static void newEspresso() {
		Espresso espresso = new Espresso("Espresso", 3.50, "Wake Up!", false, false);

		System.out.println("How many espressos would you like?");
		int espressoQuantity = scan.nextInt();
		espresso.setQuantity(espressoQuantity);
		System.out.println("Extra Shot $2.00 ea. (y/n)");
		String exShot = scan.next();
		System.out.println("Macchiato $1.00 ea. (y/n)");
		String mac = scan.next();
		espresso.addOptions(exShot, mac);
		orderItems.add(espresso);
		
	}
	
	public static void newCappuccino() {
		Cappuccino cappuccino = new Cappuccino("Cappuccino", 4.79, "Delicioso", false, false);
		
		System.out.println("How many cappuccinos would you like?");
		int cappuccinoQuantity = scan.nextInt();
		cappuccino.setQuantity(cappuccinoQuantity);
		System.out.println("Peppermint $2.00 ea. (y/n)");
		String pep = scan.next();
		System.out.println("Whipped Cream $1.00 ea. (y/n)");
		String whip = scan.next();
		cappuccino.addOptions(pep, whip);
		orderItems.add(cappuccino);
	}
	
	

}
