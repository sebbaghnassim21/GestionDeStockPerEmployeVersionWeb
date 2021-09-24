package com.GestionEmployes.fr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.GestionEmployes.fr.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long > {
	
List<Employee> findAllBysociete(String societe);

@Query("select p from Employee p where p.societe =:societe")
List<Employee> findChampBysociete(@Param("societe")String societe);
public Employee findByid(int id);
 void delete(Employee employee) ;


}
