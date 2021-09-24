package com.GestionEmployes.fr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionEmployes.fr.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAllByutilisateur(String utilisateur);
	public User findByid(int id);
	public User findByUtilisateur(String utilisateur);
	void delete(User user);

}
