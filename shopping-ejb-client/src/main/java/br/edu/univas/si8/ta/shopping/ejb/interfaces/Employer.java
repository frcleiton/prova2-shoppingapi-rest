package br.edu.univas.si8.ta.shopping.ejb.interfaces;

public interface Employer {
	
	void createNewEmployer(String nameEmployer, double salaryEmployer);
	
	void updateEmployer(int idEmployer, double salaryEmployer);
	
	String getNameById(int id);
	
	String[] listEmployerNames();
	
	String listEmployerObjNames();
	
	String getEmployerById(int id);
	

}
