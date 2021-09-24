package com.GestionEmployes.fr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "mouvement")
public class Mouvement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "codepro")
	private String codepro;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "qtes")
	private int qtes ;
	
	@Column(name = "qtesentrer")
	private int qtesentrer =0;
	
	@Column(name = "qtesortie")
	private int qtesortie =0 ;
	
	@Column(name = "prix")
	private float Prix ;
	
	@Column(name = "montant")
	private float montant ;
	
	@Column(name= "type")
	private String type;
	
	@Column(name= "societe")
	private String societe;
	
	@Column(name="information")
	private String information;
	
	@Column(name="utilisateur")
	private String Utilisateur;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	 @JsonIgnore
	 @ManyToOne private Employee mouvemp;

	public Mouvement() {
		super();
		// TODO Auto-generated constructor stub
	}


    public Mouvement(int id, String codepro, String designation, int qtes, int qtesentrer, int qtesortie, float prix,
			float montant, String type, String societe, String information, String utilisateur, Date date,
			Employee mouvemp) {
		super();
		this.id = id;
		this.codepro = codepro;
		this.designation = designation;
		this.qtes = qtes;
		this.qtesentrer = qtesentrer;
		this.qtesortie = qtesortie;
		Prix = prix;
		this.montant = montant;
		this.type = type;
		this.societe = societe;
		this.information = information;
		Utilisateur = utilisateur;
		this.date = date;
		this.mouvemp = mouvemp;
	}








	public String getInformation() {
		return information;
	}








	public void setInformation(String information) {
		this.information = information;
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

	public String getCodepro() {
		return codepro;
	}

	public void setCodepro(String codepro) {
		this.codepro = codepro;
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











	public float getMontant() {
		return montant;
	}











	public void setMontant(float montant) {
		this.montant = montant;
	}











	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getMouvemp() {
		return mouvemp;
	}

	public void setMouvemp(Employee mouvemp) {
		this.mouvemp = mouvemp;
	}



	public int getQtesentrer() {
		return qtesentrer;
	}



	public void setQtesentrer(int qtesentrer) {
		this.qtesentrer = qtesentrer;
	}



	public int getQtesortie() {
		return qtesortie;
	}



	public void setQtesortie(int qtesortie) {
		this.qtesortie = qtesortie;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	public String getUtilisateur() {
		return Utilisateur;
	}


	public void setUtilisateur(String utilisateur) {
		Utilisateur = utilisateur;
	}

    
}
