package com.GestionEmployes.fr.modelallcom;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.GestionEmployes.fr.model.Mouvement;



@Entity
@Table(name = "employeallcom")
public class EmployeeAllcom implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "datenaissance")
	private Date datenaissance;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "tel")
	private String Tel;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "societe")
	private String societe;
	
	@Column(name = "voiture")
	private String voiture;
	
	@Column(name = "cg")  // carte gasoil
	private String cg;
	
	@Column(name = "zone")
	private String Zone;
	
	
	@Column(name = "dateentrer")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateentrer;
	
	@Column(name = "operateur")
	private String operateur;
	
	@Column(name = "typec")
	private String Typecontrat;
	
	@Column(name = "datefinpe")
	private Date datefinpe;
	
	@Column(name = "datefinc")
	private Date datefinc;
	
	@Column(name = "cartegrise")
	private String cartegrise;
	
	@Column(name = "carteverre")
	private String carteverre;
	
	@Column(name = "cartebtp")
	private String cartebtp;
	
	  @OneToMany(mappedBy="mouvempallcom",fetch=FetchType.LAZY) private
	  Collection<MouvementAllcom> mouvementsallcom;

	public EmployeeAllcom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeAllcom(int id, String code, String name, String photo, String prenom, Date datenaissance,
			String adresse, String tel, String mail, String societe, String voiture, String cg, String zone,
			Date dateentrer, String operateur, String typecontrat, Date datefinpe, Date datefinc, String cartegrise,
			String carteverre, String cartebtp, Collection<MouvementAllcom> mouvementsallcom) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.photo = photo;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		Tel = tel;
		this.mail = mail;
		this.societe = societe;
		this.voiture = voiture;
		this.cg = cg;
		Zone = zone;
		this.dateentrer = dateentrer;
		this.operateur = operateur;
		Typecontrat = typecontrat;
		this.datefinpe = datefinpe;
		this.datefinc = datefinc;
		this.cartegrise = cartegrise;
		this.carteverre = carteverre;
		this.cartebtp = cartebtp;
		this.mouvementsallcom = mouvementsallcom;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getVoiture() {
		return voiture;
	}

	public void setVoiture(String voiture) {
		this.voiture = voiture;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public String getZone() {
		return Zone;
	}

	public void setZone(String zone) {
		Zone = zone;
	}

	public Date getDateentrer() {
		return dateentrer;
	}

	public void setDateentrer(Date dateentrer) {
		this.dateentrer = dateentrer;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public String getTypecontrat() {
		return Typecontrat;
	}

	public void setTypecontrat(String typecontrat) {
		Typecontrat = typecontrat;
	}

	public Date getDatefinpe() {
		return datefinpe;
	}

	public void setDatefinpe(Date datefinpe) {
		this.datefinpe = datefinpe;
	}

	public Date getDatefinc() {
		return datefinc;
	}

	public void setDatefinc(Date datefinc) {
		this.datefinc = datefinc;
	}

	public String getCartegrise() {
		return cartegrise;
	}

	public void setCartegrise(String cartegrise) {
		this.cartegrise = cartegrise;
	}

	public String getCarteverre() {
		return carteverre;
	}

	public void setCarteverre(String carteverre) {
		this.carteverre = carteverre;
	}

	public String getCartebtp() {
		return cartebtp;
	}

	public void setCartebtp(String cartebtp) {
		this.cartebtp = cartebtp;
	}

	public Collection<MouvementAllcom> getMouvementsallcom() {
		return mouvementsallcom;
	}

	public void setMouvementsallcom(Collection<MouvementAllcom> mouvementsallcom) {
		this.mouvementsallcom = mouvementsallcom;
	}



}
