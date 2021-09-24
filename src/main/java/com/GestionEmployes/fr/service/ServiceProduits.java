package com.GestionEmployes.fr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionEmployes.fr.model.Produits;
import com.GestionEmployes.fr.repository.ProduitsRepository;
@Service("ServiceProduits")
public class ServiceProduits implements InterfaceProduits {
    @Autowired
	private ProduitsRepository produitsRepository;
	
	@Override
	public List<Produits> findAllBysociete(String societe) {
		// TODO Auto-generated method stub
		return produitsRepository.findAllBysociete(societe);
	}

	@Override
	public void Save(Produits produits) {
		// TODO Auto-generated method stub
		produitsRepository.save(produits);
		
	}

	@Override
	public Produits  findBycodeAndSociete(String code,String societe) {
		// TODO Auto-generated method stub
		return produitsRepository.findBycodeAndSociete(code, societe);
	}

	@Override
	public Produits findByid(int id) {
		// TODO Auto-generated method stub
		return produitsRepository.findByid(id);
	}

	@Override
	public void delete(Produits entity) {
		produitsRepository.delete(entity);
		
	}

	

}
