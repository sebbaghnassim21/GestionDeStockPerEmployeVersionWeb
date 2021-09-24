package com.GestionEmployes.fr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.GestionEmployes.fr.model.Employee;
import com.GestionEmployes.fr.model.User;
import com.GestionEmployes.fr.service.ServiceUser;



@Controller
public class UserController {

	@Autowired
	private ServiceUser serviceuser;
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView listeUser(ModelAndView modelandview,Model modeluser) {
		
		List<User> listeuser =serviceuser.findALL();
		modeluser.addAttribute("user", listeuser) ;
		modelandview.setViewName("utilisateur");
		return modelandview;
		}
	

	 @RequestMapping(value="/nouvuser", method = RequestMethod.GET)
	 public ModelAndView nouvuser(ModelAndView modelAndView,Model modelEmployee){
		
		 
		 
		   modelAndView.setViewName("nouvuser");
		 return modelAndView;
	 }
	 
	 @RequestMapping(value="saveuser", method = RequestMethod.POST)
		public String saveshopmag(Model saveuser,User user  ){
		   user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		   user.setActive(true);
		   serviceuser.Save(user);
			return "redirect:/user";
		   /* modelAndView.setViewName("listemagasin");*/
			
			
		 
	 }
	 
	 @RequestMapping(value="/edituser", method = RequestMethod.GET)
	 public ModelAndView edituser(ModelAndView modelAndView,Model modeluser,int id){
		
		 User user =serviceuser.findByid(id);
		 
		 modeluser.addAttribute("user", user); 
		   modelAndView.setViewName("edituser");
		 return modelAndView;
		 
		 
	 }
		 
	 
	 @RequestMapping(value="/deleteuser",method = RequestMethod.GET)
	  public String deleteuser(int id){
		 User user =serviceuser.findByid(id);
	 serviceuser.delete(user);
	 return "redirect:/user";

	  }
}
