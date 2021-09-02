package com.me.bookstore;

import com.me.bookstore.pojo.Profile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.bookstore.dao.ProfileDAO;
import com.me.bookstore.pojo.Post;

@Controller
public class ProfileController {
	
	@GetMapping("/profile/create.htm")
	public String Profile() {
		
		return "create-profile";
	}
	
	@RequestMapping(value="/profile/success.htm", method=RequestMethod.POST)
	public String successProfile(@RequestParam("name") String name, 
			@RequestParam("uname") String uname,
			@RequestParam("pass") String pass,
			@RequestParam("email") String email,
			@RequestParam("occupation") String occupation,
			@RequestParam("areaofinterest") String aoi,
			@RequestParam("institution") String institution,
			@RequestParam("articlelink") String[] articlelinks, 
			ProfileDAO profileDAO) {
		
		
		profileDAO.createProfile(name, uname, pass, email, occupation, aoi, institution, articlelinks);

		
		return "profile_success";
	}
	

	
}
