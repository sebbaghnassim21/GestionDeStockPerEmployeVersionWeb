package com.GestionEmployes.fr.service;

import java.util.List;

import com.GestionEmployes.fr.model.User;

public interface InterfaceUser {
	
	public List<User> findAllByutilisateur(String utilisateur);
	public List<User> findALL();
	public User findByid(int id);
	public void Save(User user);
	void delete(User user);
	public User findByUtilisateur(String utilisateur);
	

}
