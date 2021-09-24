package com.GestionEmployes.fr.service;

import java.util.List;


import com.GestionEmployes.fr.model.Employee;

public interface InterfacEmployee {

	
	public List<Employee> findAllBysociete(String societe);
	public List<Employee> findChampBysociete(String societe);
	public Employee findByid(int id);
	public void Save(Employee employee);
	 void delete(Employee employee) ;
}
