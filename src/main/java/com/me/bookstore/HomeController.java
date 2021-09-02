package com.me.bookstore;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.me.bookstore.dao.HomeDAO;
import com.me.bookstore.pojo.Inbox;
import com.me.bookstore.pojo.Post;
import com.me.bookstore.pojo.Profile;

@Controller
public class HomeController {

	@GetMapping("/myprofile.htm")
	public String retrieveProfile(HttpServletRequest request) {		
		
		HttpSession session=request.getSession();
		session.getAttribute("profile");
		
		return "my-profile";
		
	}
	
	@RequestMapping(value="/post.htm")
	public String post() {
		return "create-post";
	}
	
	@RequestMapping(value="success.htm")
	public String createPost(@RequestParam("aoi") String aoi,
							 @RequestParam("articleurl") String articleurl,
							 @RequestParam("description") String description,
							 HomeDAO homeDAO, HttpServletRequest request) {
		
		
		homeDAO.newPost(aoi, articleurl, description, request);
	
		return "post-success";
	}
	
	@RequestMapping(value="aoi.htm")
	public String searchAOI(@RequestParam("area") String area, Model model, HttpServletRequest request, HomeDAO homeDAO) {
		

		ArrayList<Post> aoiposts=homeDAO.searchPosts(area);
		model.addAttribute("aoiposts", aoiposts);
		HttpSession s=request.getSession();
		s.setAttribute("aoiposts", aoiposts);
		
		
		return "aoi-search";
	}
	
	@RequestMapping(value="/search.htm")
	public String searchProfile(@RequestParam("search") String search, Model model, HttpServletRequest request, HomeDAO homeDAO) {

		ArrayList<Profile> prof=homeDAO.profileSearch(search);
		
		model.addAttribute("prof", prof);
		HttpSession s=request.getSession();
		s.setAttribute("prof", prof);

		
		return "profile-search";
	}
	
	@RequestMapping(value="/bookstore")
	public String logout(HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "index";
	}
	
	@RequestMapping(value="/message.htm")
	public String newMessage() {
		return "create-message";
	}
	
	@RequestMapping(value="/msgsuccess.htm", method=RequestMethod.GET)
	public String sendMessage(HttpServletRequest request,
			@RequestParam("recipient") String recipient,
			@RequestParam("message") String message,
			Model model, HomeDAO homeDAO) {

		
		homeDAO.message(request, message, recipient);
		
		return "msg-success";
	}
	
	
}
