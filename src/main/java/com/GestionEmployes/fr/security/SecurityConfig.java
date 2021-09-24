package com.GestionEmployes.fr.security;

import java.util.Date;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles(
		 * "ADMIN","USER");
		 * 
		 * auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles(
		 * "USER");
		 */
		
		auth.jdbcAuthentication().dataSource(dataSource)
				
				  .usersByUsernameQuery("select utilisateur as principal" +
				  ", password as credentials, active from user where utilisateur = ?")
				 
		.authoritiesByUsernameQuery("select utilisateur as principal "
				+ ",role as role , active from user where utilisateur = ?")
		.rolePrefix("ROLE_").passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
      
		
		
	 http.formLogin().loginPage("/login");
		 
		
		  http.authorizeRequests()
		  
		  
				
				 
				 
			.antMatchers("/remploye","/login","/RestInserPro","/restUser","/listproduit").permitAll()	  
				  
				  
				  
		  
		  .antMatchers(
		  "/nouemployee","/editEmployee", "/saveemployee","/deletemployee"
		  ,"/deletemouv","/nouproduit","/editProduit"
		  ,"/deletProduit","/saveproduit","/entrerStock","/trouverproStock"
		  ,"/inserprostock","/deletemouvstock","/user").hasRole("ADMIN")
		  
				
				  .antMatchers("/","/employee","/listeemploye",
				  "/mouvementEmployee","/produits","/trouverpro","/inserpro").hasAnyRole("ADMIN","USER")
				 
		   
		  .anyRequest().authenticated()    
          .and()
          .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
          .and().logout().logoutSuccessUrl("/login?logout")	
		  .and()
		 .exceptionHandling().accessDeniedPage("/403");
          
	
		 
		 
		  
				
		 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("user"));

		return encoder;
	}
}
