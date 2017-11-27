package br.edu.univas.si8.ta.shopping.ejb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "employers")
@SequenceGenerator(name = "seq_employers", sequenceName = "seq_employers", allocationSize = 1)

public class Employer {

	@Id
	@GeneratedValue(generator = "seq_employers", strategy = GenerationType.SEQUENCE)
	private Integer Id;

	private String name;
	private double salary;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */

}
