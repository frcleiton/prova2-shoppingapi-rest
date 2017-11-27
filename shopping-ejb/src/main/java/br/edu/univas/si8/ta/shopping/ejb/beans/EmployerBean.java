package br.edu.univas.si8.ta.shopping.ejb.beans;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.univas.si8.ta.shopping.ejb.dao.EmployerDAO;
import br.edu.univas.si8.ta.shopping.ejb.entities.Employer;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.EmployerLocal;
import br.edu.univas.si8.ta.shopping.ejb.interfaces.EmployerRemote;


@Stateless
@Remote(EmployerRemote.class)
@Local(EmployerLocal.class)
public class EmployerBean implements EmployerRemote, EmployerLocal {

	@EJB
	private EmployerDAO dao;
	
	@Override
	public void createNewEmployer(String nameEmployer, double salaryEmployer) {
		Employer employer = new Employer();
		employer.setName(nameEmployer);
		employer.setSalary(salaryEmployer);
		dao.insert(employer);		
	}

	@Override
	public String[] listEmployerNames() {
		return dao.listAll()
				.stream()
				.map(Employer::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

	@Override
	public String getNameById(int id) {
		return dao.getNameById(id);
	}

	@Override
	public String getEmployerById(int id) {
		return dao.getEmployerById(id);
	}

	@Override
	public String listEmployerObjNames() {
		return dao.listObjAll();
	}

	@Override
	public void updateEmployer(int idEmployer, double salaryEmployer) {
		dao.update(idEmployer, salaryEmployer);		
	}

}
