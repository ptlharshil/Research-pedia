package com.me.bookstore;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.bookstore.dao.LoginDAO;
import com.me.bookstore.pojo.Post;
import com.me.bookstore.pojo.Profile;

@Controller
public class LoginController {

	@RequestMapping(value="login.htm", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password, Model model, 
						HttpServletRequest request, LoginDAO loginDAO) {
		

		String p=password;
		Profile pl= loginDAO.signin(username);
		
		if(pl!=null && pl.getPassword().equals(p))
		{
			
			model.addAttribute("Profile", pl);
			
			List<Post> allposts=loginDAO.allPosts();
			model.addAttribute("allposts", allposts);
			HttpSession s=request.getSession();
			s.setAttribute("profile", pl);
			s.setAttribute("allposts", allposts);
			return "home-page";
		}

		
		return "login-fail";
	}
	
	
}
