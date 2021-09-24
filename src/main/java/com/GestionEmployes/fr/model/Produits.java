package com.GestionEmployes.fr.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "produits")
public class Produits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "qtes")
	private int qtes ;
	
	@Column(name = "prix")
	private float Prix ;

	@Column(name = "pamp")
	private float pamp =0;
	
	@Column(name = "min")
	private int min =0;
	
	@Column(name= "societe")
	private String societe;
	
	public Produits() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Produits(int id, String code, String designation, int qtes, float prix, float pamp, int min,
			String societe) {
		super();
		this.id = id;
		this.code = code;
		this.designation = designation;
		this.qtes = qtes;
		Prix = prix;
		this.pamp = pamp;
		this.min = min;
		this.societe = societe;
	}




















	public String getSociete() {
		return societe;
	}







	public void setSociete(String societe) {
		this.societe = societe;
	}







	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public int getQtes() {
		return qtes;
	}



	public void setQtes(int qtes) {
		this.qtes = qtes;
	}







	public int getMin() {
		return min;
	}



	public void setMin(int min) {
		this.min = min;
	}










	public float getPrix() {
		return Prix;
	}










	public void setPrix(float prix) {
		Prix = prix;
	}










	public float getPamp() {
		return pamp;
	}










	public void setPamp(float pamp) {
		this.pamp = pamp;
	}
	
	
	
	

}
