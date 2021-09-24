package com.GestionEmployes.fr.service;

import java.util.List;


import com.GestionEmployes.fr.model.Produits;

public interface InterfaceProduits {
	
	public List<Produits> findAllBysociete(String societe);
	public void Save(Produits produits);
    public Produits findBycodeAndSociete(String code,String societe);
    public Produits findByid(int id);
    public void delete(Produits entity);

}
