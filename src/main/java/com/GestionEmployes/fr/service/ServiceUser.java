package com.GestionEmployes.fr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionEmployes.fr.model.User;
import com.GestionEmployes.fr.repository.UserRepository;


@Service("ServiceUser")
public class ServiceUser implements InterfaceUser {

	@Autowired
	private UserRepository userrepository;
	@Override
	public List<User> findAllByutilisateur(String utilisateur) {
		// TODO Auto-generated method stub
		return userrepository.findAllByutilisateur(utilisateur) ;
	}

	@Override
	public User findByid(int id) {
		// TODO Auto-generated method stub
		return userrepository.findByid(id);
	}

	@Override
	public void Save(User user) {
		
		userrepository.save(user);
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userrepository.delete(user);
	}

	@Override
	public List<User> findALL() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public User findByUtilisateur(String utilisateur) {
		// TODO Auto-generated method stub
		return userrepository.findByUtilisateur(utilisateur);
	}

}
