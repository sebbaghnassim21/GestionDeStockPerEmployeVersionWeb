package com.GestionEmployes.fr.modelallcom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="produitallcom")
public class ProduitAllcom implements Serializable {

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

	public ProduitAllcom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProduitAllcom(int id, String code, String designation, int qtes, float prix, float pamp, int min) {
		super();
		this.id = id;
		this.code = code;
		this.designation = designation;
		this.qtes = qtes;
		Prix = prix;
		this.pamp = pamp;
		this.min = min;
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

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
