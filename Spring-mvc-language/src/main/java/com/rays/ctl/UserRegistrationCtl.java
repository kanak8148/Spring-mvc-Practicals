package com.rays.ctl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "Register")
public class UserRegistrationCtl {

	@Autowired
	UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {
		return "UserRegistration";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserRegistrationForm form) {
		UserDTO dto = new UserDTO();
		System.out.println(form.getFirstName());
		System.out.println(form.getLastName());
		System.out.println(form.getLogin());
		System.out.println(form.getPassword());
		System.out.println(form.getDob());
		System.out.println(form.getAddress());
		
		  
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		try {
			dto.setDob(sdf.parse(form.getDob()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setAddress(form.getAddress());

		service.add(dto);

		return "UserRegistration";
	}

}
