package com.eventmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eventmanager.entities.Manager;



@Controller
public class LoginController {
	
	@Autowired
	UserDetailsManager udm;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping("/loginForm")
	public String showLoginForm() {
		return "login-form";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "access-denied.jsp";
	}
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		theModel.addAttribute("user",new Manager());
		return "registration";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") Manager theUser) {
		//check database if user exists
		boolean exists = udm.userExists(theUser.getUsername());
		if(exists) {
			System.out.println("user exists");
			return "registration";
		}
			
		//encrypt password
		String encodedPassword = "{bcrypt}"+encoder.encode(theUser.getPassword());
			
		//set up user roles
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		
		//this user is from spring framework
		User temp = new User(theUser.getUsername(),encodedPassword,authorities);
		
		//save user in database
		udm.createUser(temp);
		
		return "redirect:/loginForm";
	}
	
}





