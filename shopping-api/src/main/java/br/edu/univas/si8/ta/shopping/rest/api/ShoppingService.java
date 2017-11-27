package br.edu.univas.si8.ta.shopping.rest.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public interface ShoppingService {
	
	@GET
	@Path("/order/all")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listAllOrders();
	
	@POST
	@Path("/order/add")
	@Produces(MediaType.APPLICATION_JSON)
	String saveNewOrder(@FormParam("description") String description);
	
}
