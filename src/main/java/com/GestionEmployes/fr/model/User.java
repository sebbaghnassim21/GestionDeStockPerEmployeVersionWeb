package com.GestionEmployes.fr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "utilisateur")
	private String utilisateur;
	
	@Column(name = "password")
	private String password;
	
	@Column (name="role")
	private String role;
	
	@Column(name="active")
	private boolean active;
	 

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public User(int id, String utilisateur, String password, String role, boolean active) {
		super();
		this.id = id;
		this.utilisateur = utilisateur;
		this.password = password;
		this.role = role;
		this.active = active;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	public boolean isActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
