package com.GestionEmployes.fr.RestController;

import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.model.Mouvement;
import com.GestionEmployes.fr.model.Produits;
import com.GestionEmployes.fr.model.User;
import com.GestionEmployes.fr.service.ServiceMouvement;
import com.GestionEmployes.fr.service.ServiceProduits;
import com.GestionEmployes.fr.service.ServiceUser;
import com.GestionEmployes.fr.service.ServicesEmployee;

@RestController
public class HomeRestController {

	@Autowired
	private ServicesEmployee servicesEmployee;
	
	@Autowired
	private ServiceMouvement serviceMouvement;
	
	@Autowired
	private ServiceProduits serviceProduit;
	
	@Autowired
	private ServiceUser serviceuser;

	    @RequestMapping(value="/remploye", method=RequestMethod.GET)
	    public List<Employee> listeEmploi(String societe) {
	    	
	    	List<Employee> employee= servicesEmployee.findChampBysociete(societe);
	 	 //	List<Employee> employee= servicesEmployee.findAllBysociete("ITS");
	    		
	        return employee;
	    }
	    
	    @RequestMapping(value="/listproduit", method=RequestMethod.GET)
	    public List<Mouvement> listeProduit(int id)
	    {
	    	Employee employee =servicesEmployee.findByid(id);
	    	List<Mouvement> mouvement=serviceMouvement.findBymouvemp(employee);
			return mouvement;
	    	
	    }
	    
		 @RequestMapping(value="/RestInserPro", method = RequestMethod.GET)
		 public String restinserpro(String code,
				 int id,String societe,String user ){
		  
			int qtes=1;
			 
		      Produits produits=serviceProduit.findBycodeAndSociete(code, societe);
		    // if (produits!=null ) {
		      Employee employee =servicesEmployee.findByid(id);
		      Mouvement mouve=new Mouvement();
		      mouve.setCodepro(produits.getCode());
		      mouve.setDesignation(produits.getDesignation());
		      mouve.setPrix(produits.getPrix());
		      mouve.setMouvemp(employee);
		      mouve.setQtes(qtes);
		      mouve.setQtesortie(qtes);
		      mouve.setMontant(produits.getPrix()*qtes);
		      mouve.setSociete(societe);
		      mouve.setUtilisateur(user);
		      mouve.setDate(new Date());
		     serviceMouvement.Save(mouve);
		     
/////////////////////////////////////////DESTOCKAGE
		     
		     produits.setQtes(produits.getQtes()-qtes);
		     serviceProduit.Save(produits);
		     
			return employee.getName() ;   
		
		     
		 }
		 
		 
		 
		 @RequestMapping(value="/restUser", method = RequestMethod.GET)
		 public String restUser(String password, String user) 
		 {
			 User users=serviceuser.findByUtilisateur(user);
			 
			 BCryptPasswordEncoder b=new BCryptPasswordEncoder();
	       boolean pass= b.matches(password, users.getPassword());
	       
			 
			 if (pass) {
				
			 return "OK";
			 }else
			 {
				 return "NO";
			 }
			 
		 } 
}
