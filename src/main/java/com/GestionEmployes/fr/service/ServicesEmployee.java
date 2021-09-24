package com.GestionEmployes.fr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.repository.EmployeeRepository;
@Service("ServicesEmployee")
public class ServicesEmployee implements InterfacEmployee {
	
	@Autowired 
	private EmployeeRepository employeerepository;

	@Override
	public List<Employee> findAllBysociete(String societe) {
		// TODO Auto-generated method stub
		return employeerepository.findAllBysociete(societe);
	}

	@Override
	public Employee findByid(int id) {
		// TODO Auto-generated method stub
		return employeerepository.findByid(id);
	}

	@Override
	public void Save(Employee employee) {
		// TODO Auto-generated method stub
		employeerepository.save(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeerepository.delete(employee);
		
	}

	@Override
	public List<Employee> findChampBysociete(String societe) {
		return employeerepository.findChampBysociete(societe);
	}



}
