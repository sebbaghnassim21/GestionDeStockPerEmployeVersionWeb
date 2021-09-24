package com.GestionEmployes.fr.service;

import java.util.Date;
import java.util.List;

import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.model.Mouvement;

public interface InterfaceMouvement {
	
	public List<Mouvement> findBymouvemp(Employee employee);
	public List<Mouvement> findBydate(Date date);
	public void Save(Mouvement mouvement);
	void delete(Mouvement mouvement);
	public Mouvement findByid(int id);
	public List<Mouvement> findBydateTypeSociete(Date date,String type,String societe);
}
