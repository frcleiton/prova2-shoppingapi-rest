package br.edu.univas.si8.ta.shopping.ejb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "shopping_order")
@SequenceGenerator(name = "seq_shopping_order", sequenceName = "seq_shopping_order", allocationSize = 1)

public class Order {

	@Id
	@GeneratedValue(generator = "seq_shopping_order", strategy = GenerationType.SEQUENCE)
	private Integer Id;

	private String description;
	
	@Column(name="order_time", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date order_time;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	
	
	
}
