package br.edu.univas.si8.ta.shopping.ejb.beans;

import java.util.Date;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.univas.si8.ta.shopping.ejb.dao.OrderDAO;
import br.edu.univas.si8.ta.shopping.ejb.entities.Order;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderLocal;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.OrderRemote;


@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderRemote, OrderLocal {

	@EJB
	private OrderDAO dao;
	
	@Override
	public void createNewOrder(String descriptionOrder) {
		Order order = new Order();
		order.setDescription(descriptionOrder);
		order.setOrder_time(new Date());
		dao.insert(order);		
	}

	@Override
	public String[] listAllOrders() {
		return dao.listAll()
				.stream()
				.map(Order::getDescription)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}
	
}
