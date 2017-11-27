package br.edu.univas.si8.ta.shopping.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONObject;

import br.edu.univas.si8.ta.shopping.ejb.entities.Employer;

@Stateless
public class EmployerDAO {
	
	@PersistenceContext(unitName = "employer")
	private EntityManager em;
	
	public void insert(Employer employer) {
		em.persist(employer);
	}
	
	public List<Employer> listAll() {
		return em.createQuery("from employers c", Employer.class).getResultList();
	}
	
	public String getNameById(int id) {
		return em.find(Employer.class, id).getName();
	}
	
	public String getEmployerById(int id) {
		Employer emp = em.find(Employer.class, id);
		JSONObject obj = new JSONObject();
		obj.put("Id", emp.getId());
		obj.put("Name", emp.getName());
		obj.put("Salary", emp.getSalary());
		return obj.toString();
	}
	
	public String listObjAll() {
		List<Employer> employers = em.createQuery("from employers c", Employer.class).getResultList();
		JSONObject obj = new JSONObject();
		StringBuilder sBuilder = new StringBuilder();
		for (Employer emp: employers) {
			obj.put("Id", emp.getId());
			obj.put("Name", emp.getName());
			obj.put("Salary", emp.getSalary());
			sBuilder.append(obj);	
		}
		return sBuilder.toString();
	}
	
	public void update (Employer employer) {
		Employer emp = em.find(Employer.class, (int)employer.getId());
		emp.setSalary(employer.getSalary());
		em.merge(emp);
	}

	public void update(int idEmployer, double salaryEmployer) {
		Employer emp = em.find(Employer.class, idEmployer);
		emp.setSalary(salaryEmployer);
		em.merge(emp);
	}
}
