package com.GestionEmployes.fr.controller;


import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.model.Mouvement;
import com.GestionEmployes.fr.model.Produits;
import com.GestionEmployes.fr.service.ServiceMouvement;
import com.GestionEmployes.fr.service.ServiceProduits;
import com.GestionEmployes.fr.service.ServicesEmployee;

@Controller
public class HomeController {
	
	@Autowired
	private ServicesEmployee servicesEmployee;

	@Autowired
	private ServiceMouvement serviceMouvement;
	
	@Autowired
	private ServiceProduits serviceProduit;

	private String societe;
	private String a;
    private String etatmouve;	
	

	

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelandview) {
		
		modelandview.setViewName("index");
		
		return modelandview;}
	
	
	 @RequestMapping(value="/employee", method = RequestMethod.GET)
	public ModelAndView homeEmploye(ModelAndView modelAndView,Model modelEmployee,String so ){
		
		
		societe=so;
		List<Employee> employee= servicesEmployee.findAllBysociete(societe);
		modelEmployee.addAttribute("employee",employee);
		a=societe;
		if (societe.equals("ITS")) {
			a="I.T.S";
		}
		modelEmployee.addAttribute("societe", a);	
		 
		   modelAndView.setViewName("employee");
		return modelAndView;
		
		
	}
	 
	 @RequestMapping(value="/listeemploye", method = RequestMethod.GET)
	public ModelAndView listeEmploye(ModelAndView modelAndView,Model modelEmployee ){
		
		
		
		List<Employee> employee= servicesEmployee.findAllBysociete(societe);
		modelEmployee.addAttribute("employee",employee);
		 
		a=societe;
		if (societe.equals("ITS")) {
			a="I.T.S";
		}
		modelEmployee.addAttribute("societe", a);
		
		   modelAndView.setViewName("employee");
		return modelAndView;
		
		
	}
	 
	 
	 
	 @RequestMapping(value="/nouemployee", method = RequestMethod.GET)
	 public ModelAndView nouveemploye(ModelAndView modelAndView,Model modelEmployee){
		
		 
		 
		   modelAndView.setViewName("newemployee");
		 return modelAndView;
		 
		 
	 }
	 
	 
	 //editEmployee
	 @RequestMapping(value="/editEmployee", method = RequestMethod.GET)
	 public ModelAndView editEmployee(ModelAndView modelAndView,Model modelEmployee,int id){
		
		 Employee employee =servicesEmployee.findByid(id);
		 modelEmployee.addAttribute("employee", employee); 
		   modelAndView.setViewName("editEmployee");
		 return modelAndView;
		 
		 
	 }
	 
	 
	 @RequestMapping(value="saveemployee", method = RequestMethod.POST)
		public String saveshopmag(Model savenoumag,Employee employee  ){
		   employee.setSociete(societe); 
		   servicesEmployee.Save(employee);
			return "redirect:/employee?so="+societe;
		   /* modelAndView.setViewName("listemagasin");*/
			
			
		 
	 }
	 
	 @RequestMapping(value="deletemployee",method = RequestMethod.GET)
	  public String deletemag(int id){
		 Employee employee =servicesEmployee.findByid(id);
	 servicesEmployee.delete(employee);
	 return "redirect:/employee?so="+societe;

	  }
	 
	 
	int ids;
	 
	 @RequestMapping(value="/mouvementEmployee", method = RequestMethod.GET)
	 public ModelAndView mouvementEmployee(ModelAndView modelAndView,Model mouvEmployee,int id){
	     Employee employee =servicesEmployee.findByid(id);
		 List<Mouvement> mouvement =serviceMouvement.findBymouvemp(employee);
		ids=id;
		// if (mouvement == null ) {System.out.println("  null");}
		Produits produits=new Produits();
		 mouvEmployee.addAttribute("mouvement", mouvement);
		 mouvEmployee.addAttribute("produits", produits);
		 mouvEmployee.addAttribute("employee", employee);
		 a=societe;
		 if (societe.equals("ITS")) {
				a="I.T.S";
			}
		 mouvEmployee.addAttribute("societe", a);
		 
		 
		   modelAndView.setViewName("mouvemployee");
		 return modelAndView;
		 
		 
	 }
	 
	//trouverpro 
	 
	 @RequestMapping(value="/trouverpro", method = RequestMethod.GET)
	 public ModelAndView trouverpro(ModelAndView modelAndView,Model mouvEmployee,String mc){
	  
	      Produits produits=serviceProduit.findBycodeAndSociete(mc, societe);
	      Employee employee =servicesEmployee.findByid(ids);
	    //  Mouvement mouve=new Mouvement();
	  //    mouve.setCodepro(produits.getCode());
	   //   mouve.setDesignation(produits.getDesignation());
	  //    mouve.setPrix(produits.getPrix());
	  //    mouve.setMouvemp(employee);
	    //  mouve.setQtes(qtes);
	   //   serviceMouvement.Save(mouve);
	      
	      
		 
		 List<Mouvement> mouvement =serviceMouvement.findBymouvemp(employee);
		
		 mouvEmployee.addAttribute("mouvement", mouvement);
		 mouvEmployee.addAttribute("produits", produits);
		 mouvEmployee.addAttribute("employee", employee);
		 a=societe;
		 if (societe.equals("ITS")) {
				a="I.T.S";
			}
		 mouvEmployee.addAttribute("societe", a);
		 
		 
		   modelAndView.setViewName("mouvemployee");
		 return modelAndView;
		 
		 
	 }
	 
	 
	// inserpro
	 
	 @RequestMapping(value="/inserpro", method = RequestMethod.GET)
	 public ModelAndView inserpro(ModelAndView modelAndView,Model mouvEmployee,String code
			 ,int qtes,String designation,float Prix,Principal principal){
	  
		
		 
	      Produits produits=serviceProduit.findBycodeAndSociete(code, societe);
	      Employee employee =servicesEmployee.findByid(ids);
	      Mouvement mouve=new Mouvement();
	      mouve.setCodepro(produits.getCode());
	      mouve.setDesignation(produits.getDesignation());
	      mouve.setPrix(produits.getPrix());
	      mouve.setMouvemp(employee);
	      mouve.setQtes(qtes);
	      mouve.setQtesortie(qtes);
	      mouve.setMontant(Prix*qtes);
	      mouve.setUtilisateur(principal.getName());
	     
	      mouve.setDate(new Date());
	     serviceMouvement.Save(mouve);
	     
  // modifier le produit qtes et pamp
	     
	     produits.setQtes(produits.getQtes()-qtes);
	     serviceProduit.Save(produits);
	     
	     ////////////////////////////////////
	      
	      produits=new Produits();
		 
		 List<Mouvement> mouvement =serviceMouvement.findBymouvemp(employee);
		
		 a=societe;
		 if (societe.equals("ITS")) {
				a="I.T.S";
			}
		 mouvEmployee.addAttribute("societe", a);
		 
		 mouvEmployee.addAttribute("mouvement", mouvement);
		 mouvEmployee.addAttribute("produits", produits);
		 mouvEmployee.addAttribute("employee", employee);
		   modelAndView.setViewName("mouvemployee");
		 return modelAndView;
		 
		 
	 }
	 
	 @RequestMapping(value="deletemouv",method = RequestMethod.GET)
	  public ModelAndView deletemouvm(ModelAndView modelAndView,int id,Model mouvEmployee){
	
		 Mouvement mouv =serviceMouvement.findByid(id);
	// modifier le produit qtes et pamp	 
		 Produits produit=serviceProduit.findBycodeAndSociete(mouv.getCodepro(), societe);
         produit.setQtes(produit.getQtes()+mouv.getQtes());
	     serviceProduit.Save(produit);
	     
	////////////////////////////////////
		 
		 serviceMouvement.delete(mouv);
		 
		 Employee employee =servicesEmployee.findByid(ids);
		 List<Mouvement> mouvement =serviceMouvement.findBymouvemp(employee);
	
		// if (mouvement == null ) {System.out.println("  null");}
		Produits produits=new Produits();
		 mouvEmployee.addAttribute("mouvement", mouvement);
		 mouvEmployee.addAttribute("produits", produits);
		 mouvEmployee.addAttribute("employee", employee);
		 a=societe;
		 if (societe.equals("ITS")) {
				a="I.T.S";
			}
		 mouvEmployee.addAttribute("societe", a);
		 
		   modelAndView.setViewName("mouvemployee");
		 return modelAndView;

	  }
	 
	 
	 //////////////////////////////////////////////////////////////////////////::
	 //////////////////////////////////////////////////////////////////////////
	 //////////////////////////////////////////////////////////////////////////
	 /////////////////////PRODUIT/////////////////////////////////////////////
	 
	 
	
		
		
		 @RequestMapping(value="/produits", method = RequestMethod.GET)
		public ModelAndView home(ModelAndView modelAndView,Model modelProduits ){
			
			List<Produits> produits= serviceProduit.findAllBysociete(societe);
			modelProduits.addAttribute("produits",produits);
			a=societe;
			if (societe.equals("ITS")) {
				a="I.T.S";
			}
			modelProduits.addAttribute("societe", a);	
			   modelAndView.setViewName("produits");
			return modelAndView;
			
			
		}
		 
		 
		 @RequestMapping(value="/nouproduit", method = RequestMethod.GET)
		 public ModelAndView nouproduit(ModelAndView modelAndView,Model modelProduit){
			
			 
			 
			   modelAndView.setViewName("newproduit");
			 return modelAndView;
			 
			 
		 }
		 
		 @RequestMapping(value="/editProduit", method = RequestMethod.GET)
		 public ModelAndView editProduit(ModelAndView modelAndView,Model modelProduit,int id){
			
		// employee =servicesEmployee.findByid(id);
			 Produits produit=serviceProduit.findByid(id);
			 modelProduit.addAttribute("produit", produit); 
			   modelAndView.setViewName("editProduit");
			 return modelAndView;
			 
			 
		 }
		 
		 @RequestMapping(value="deletProduit",method = RequestMethod.GET)
		  public String deletProduit(int id){
			 Produits produit =serviceProduit.findByid(id);
			 serviceProduit.delete(produit);
			return "redirect:/produits";

		  }
		 
		 
		 @RequestMapping(value="saveproduit", method = RequestMethod.POST)
			public String saveshopmag(Model savenoumag,Produits produits  ){
			   produits.setPamp(produits.getPrix()); 
			   produits.setSociete(societe);
			   serviceProduit.Save(produits);
			   
				return "redirect:/produits";
			 
				
				
			 
		 }
		 
		 
		 /////////////////////////////////////////////////////////////////////////////////////////
		 ////////////////////////////////////////////////////////////////////////////////////////
		 /////////////////////////////////////////////////////////////////////////////////////////
		 //////////////////////////////////////Entrer stock//////////////////////////////////////
		 
		 
		 

		 @RequestMapping(value="/entrerStock", method = RequestMethod.GET)
		 public ModelAndView entrerStock(ModelAndView modelAndView,Model enStock,String typemouv){
		 
			 List<Mouvement> mouvement =serviceMouvement.findBydateTypeSociete(new Date(), typemouv, societe);
		
			etatmouve=typemouv;
			Produits produits=new Produits();
			enStock.addAttribute("mouvement", mouvement);
			enStock.addAttribute("produits", produits);
			a=societe;
			 if (societe.equals("ITS")) {
					a="I.T.S";
				}
			 enStock.addAttribute("societe", a);
			
			
			   modelAndView.setViewName("EntrerMouv");
			 return modelAndView;
			 
			 
		 }
		 
		 
		 @RequestMapping(value="/trouverproStock", method = RequestMethod.GET)
		 public ModelAndView trouverproStock(ModelAndView modelAndView,Model enStock,String mc){
		  
		      Produits produits=serviceProduit.findBycodeAndSociete(mc, societe);
		  
		 
			 List<Mouvement> mouvement =serviceMouvement.findBydateTypeSociete(new Date(), etatmouve,societe);
			
			 enStock.addAttribute("mouvement", mouvement);
			 enStock.addAttribute("produits", produits);
			 a=societe;
			 if (societe.equals("ITS")) {
					a="I.T.S";
				}
			 enStock.addAttribute("societe", a);
			 
			   modelAndView.setViewName("EntrerMouv");
			 return modelAndView;
			 
			 
		 }
		 
		 
		 
		 
		 @RequestMapping(value="/inserprostock", method = RequestMethod.GET)
		 public ModelAndView inserprostock(ModelAndView modelAndView,Model mouvEmployee,String code
				 ,int qtes,String designation,String information,float Prix){
		  
			
			 
		      Produits produits=serviceProduit.findBycodeAndSociete(code, societe);
		 
		      
		      
		      
		      Mouvement mouve=new Mouvement();
		      mouve.setCodepro(produits.getCode());
		      mouve.setDesignation(produits.getDesignation());
		      mouve.setPrix(Prix);
		      mouve.setQtes(qtes);
		      mouve.setQtesentrer(qtes);
		      mouve.setMontant(Prix*qtes);
		      mouve.setDate(new Date());
		      mouve.setType(etatmouve);
		      mouve.setSociete(societe);
		      mouve.setInformation(information);
		     serviceMouvement.Save(mouve);
		     
		     // modifier le produit qtes et pamp
		     if (etatmouve.equals("Entrer")) {
		     produits.setQtes(produits.getQtes()+qtes);
		     produits.setPamp(((produits.getPamp()*produits.getQtes())+(Prix*qtes))/(qtes+produits.getQtes()));
		     }
		     if (etatmouve.equals("Sortie")) {
			     produits.setQtes(produits.getQtes()-qtes);
			   //  produits.setPamp(((produits.getPamp()*produits.getQtes())+(Prix*qtes))/(qtes+produits.getQtes()));
			     }
		     serviceProduit.Save(produits);
		     
		     ////////////////////////////////////
		     produits=new Produits();
		     List<Mouvement> mouvement =serviceMouvement.findBydateTypeSociete(new Date(), etatmouve,societe);		
			 mouvEmployee.addAttribute("mouvement", mouvement);
			 mouvEmployee.addAttribute("produits", produits);
			 a=societe;
			 if (societe.equals("ITS")) {
					a="I.T.S";
				}
			 mouvEmployee.addAttribute("societe", a);
			 
			 modelAndView.setViewName("EntrerMouv");
			 return modelAndView;
			 
			 
		 }
		 
		 
		 @RequestMapping(value="deletemouvstock",method = RequestMethod.GET)
		  public ModelAndView deletemouv(ModelAndView modelAndView,int id,Model mouvEmployee){
		
			 Mouvement mouv =serviceMouvement.findByid(id);
			 serviceMouvement.delete(mouv);
			 
			// modifier le produit qtes et pamp	 
					 Produits produit=serviceProduit.findBycodeAndSociete(mouv.getCodepro(), societe);
					 if (etatmouve.equals("Entrer")) {
			         produit.setQtes(produit.getQtes()-mouv.getQtes());
					 }
					 if (etatmouve.equals("Sortie")) {
				         produit.setQtes(produit.getQtes()+mouv.getQtes());
						 }
				     serviceProduit.Save(produit);
				     
				////////////////////////////////////
			 
			// Employee employee =servicesEmployee.findByid(ids);
			 List<Mouvement> mouvement =serviceMouvement.findBydateTypeSociete(new Date(), etatmouve,societe);
		
			// if (mouvement == null ) {System.out.println("  null");}
			Produits produits=new Produits();
			 mouvEmployee.addAttribute("mouvement", mouvement);
			 mouvEmployee.addAttribute("produits", produits);
			 a=societe;
			 if (societe.equals("ITS")) {
					a="I.T.S";
				}
			 mouvEmployee.addAttribute("societe", a);
			 
			// mouvEmployee.addAttribute("employee", employee);
			   modelAndView.setViewName("EntrerMouv");
			 return modelAndView;

		  }
	 
	 
	 
}
