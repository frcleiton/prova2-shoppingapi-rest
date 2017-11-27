package br.edu.univas.si8.ta.shopping.rest.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.edu.univas.si8.ta.shopping.ejb.interfaces.Employer;
import br.edu.univas.si8.ta.shopping.rest.api.ShoppingService;


@RequestScoped
public class ShoppingServiceImpl implements ShoppingService{

	@EJB(mappedName="java:app/shopping-ejb-0.1-SNAPSHOT/OrderBean!br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderRemote")
	private Order order;
	
	
	@Override
	public String[] listAllOrders() {
		return employer.listOrderDescriptions();
	}
	
	@Override
	public String listEmployersObjNames() {
		return employer.listEmployerObjNames();
	}

	@Override
	public String getEmployerById(int id) {
		return employer.getNameById(id);
	}

	@Override
	public String saveNewEmployer(String name, double salary) {
		employer.createNewEmployer(name, salary);
		return "{\"Message\": \"Success\"}";
	}

	@Override
	public String getEmployerObjById(int id) {
		return employer.getEmployerById(id);
	}

	@Override
	public String updateEmployer(int id, double salary) {
		employer.updateEmployer(id, salary);
		return "{\"Message\": \"Success\"}";
	}

	@Override
	public String[] listAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveNewOrder(String description) {
		order.createNewOrder(description);
		//TODO: Aqui retorna http 200
		//TODO: setar a hora atual
		return "{\"Message\": \"Success\"}";
	}
	
}
