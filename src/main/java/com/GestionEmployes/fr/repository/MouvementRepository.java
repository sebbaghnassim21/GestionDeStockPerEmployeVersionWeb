package com.GestionEmployes.fr.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.model.Mouvement;

public interface MouvementRepository extends JpaRepository<Mouvement, Long> {
	
	List<Mouvement> findBymouvemp(Employee employee);
	List<Mouvement> findBydate(Date date);
	void delete(Mouvement mouvement); 
	Mouvement findByid(int id);

	
	@Query("select p from Mouvement p where p.date =:date and p.type =:type and p.societe =:societe")
	@Transactional
	List<Mouvement> findBydateTypeSociete(@Param("date")Date date,@Param("type")String type,@Param("societe")String societe);

}
