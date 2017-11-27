package br.edu.univas.si8.ta.shopping.ejb.interfaces;

public interface Order {
	
	void createNewOrder(String descriptionOrder);
	
	String[] listAllOrders();
	
}
