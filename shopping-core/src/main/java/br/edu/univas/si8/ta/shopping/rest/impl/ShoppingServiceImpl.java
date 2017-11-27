package br.edu.univas.si8.ta.shopping.rest.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.edu.univas.si8.ta.shopping.ejb.interfaces.Order;
import br.edu.univas.si8.ta.shopping.rest.api.ShoppingService;


@RequestScoped
public class ShoppingServiceImpl implements ShoppingService{

	@EJB(mappedName="java:app/shopping-ejb-0.1-SNAPSHOT/OrderBean!br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderRemote")
	private Order order;
		
	@Override
	public String[] listAllOrders() {
		return order.listAllOrders();
	}
	
	public Response saveNewOrder(String description) {
		order.createNewOrder(description);
		return Response.status(Response.Status.CREATED).build();
	}
}
