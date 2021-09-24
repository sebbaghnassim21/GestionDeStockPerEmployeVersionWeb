package com.GestionEmployes.fr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.GestionEmployes.fr.model.Produits;

public interface ProduitsRepository extends JpaRepository<Produits, Long> {
	
List<Produits> findAllBysociete(String societe);
@Query("select p from Produits p where p.code =:code and p.societe =:societe")
@Transactional
Produits findBycodeAndSociete(@Param("code")String code,@Param("societe")String societe);
Produits findByid(int id);
void delete(Produits entity);
		

}
