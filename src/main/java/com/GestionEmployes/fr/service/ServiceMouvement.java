package com.GestionEmployes.fr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.model.Mouvement;
import com.GestionEmployes.fr.repository.MouvementRepository;
@Service("ServiceMouvement")
public class ServiceMouvement implements InterfaceMouvement{

	@Autowired
	private MouvementRepository mouvementRepository;
	
	@Override
	public List<Mouvement> findBymouvemp(Employee employee) {
		// TODO Auto-generated method stub
		return mouvementRepository.findBymouvemp(employee);
	}

	@Override
	public void Save(Mouvement mouvement) {
		// TODO Auto-generated method stub
		mouvementRepository.save(mouvement);
	}

	@Override
	public void delete(Mouvement mouvement) {
	mouvementRepository.delete(mouvement);
		
	}

	@Override
	public Mouvement findByid(int id) {
		// TODO Auto-generated method stub
		return mouvementRepository.findByid(id);
	}

	@Override
	public List<Mouvement> findBydate(Date date) {
		// TODO Auto-generated method stub
		return mouvementRepository.findBydate(date);
	}

	
	  @Override public List<Mouvement> findBydateTypeSociete(Date date, String type,String societe) { //
	 
	  return mouvementRepository.findBydateTypeSociete(date, type,societe); }
	 

}
