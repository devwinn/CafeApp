package com.perscholas.cafe3;

public class ShoppingCart {
	//get quantities and subtotals
	
	
	public static void checkout() {
		double subtotal = salesSubtotal();
		double salesTax = salesTax();
		double salesTotal = salesTotal();
		
		
		System.out.println("Your order: ");
		for (Product orders : Store.orderItems) {
			orderInfo(orders);
		}
		System.out.println("\nSales subtotal: $" + subtotal + "\nSales Tax: $" + salesTax + "\nSales Total: $" + salesTotal);
	}
	public static void orderInfo(Product p) {
		System.out.println("\nItem: " + p.getName() + "    Description: " + p.getDescription() + "    Qty: " + p.getQuantity() + "    Subtotal: " + p.calculateProductSubtotal());
		p.printOptions();
	}
	
	public static double salesSubtotal () {
		double salesSubtotal = 0; // = a.calculateProductSubtotal() + b.calculateProductSubtotal() + c.calculateProductSubtotal();	
		for (Product orders : Store.orderItems) {
			salesSubtotal += orders.calculateProductSubtotal();
		}
		double salesSubtotalRound = Math.round(salesSubtotal * 100.00) / 100.00;
		return salesSubtotalRound;
	}
	
	public static double salesTax() {
		double salesTax = 0; //a.productSalesTax() + b.productSalesTax() + c.productSalesTax();
		for (Product orders : Store.orderItems) {
			salesTax += orders.productSalesTax();
		}
		double salesTaxRound = Math.round(salesTax * 100.00) / 100.00;
		return salesTaxRound;
	}
	
	public static double salesTotal() {
		double salesTotal = 0; //(a.calculateProductSubtotal() + a.productSalesTax()) + (b.calculateProductSubtotal() + b.productSalesTax()) + (c.calculateProductSubtotal() + c.productSalesTax());
		for (Product orders : Store.orderItems) {
			salesTotal += (orders.calculateProductSubtotal() + orders.productSalesTax());
		}
		double total = Math.round(salesTotal * 100.00) / 100.00;
		return total;
	}

	//print items
}
