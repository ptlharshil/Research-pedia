package com.me.bookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.me.bookstore.dao.MessageDAO;
import com.me.bookstore.pojo.Inbox;
import com.me.bookstore.pojo.Profile;

@Controller
public class MessageController {

	@RequestMapping(value="/msg.htm", method=RequestMethod.GET)
	public String getAllMessageList(HttpServletRequest request, Model model, MessageDAO messageDAO) {

			List<List<Inbox>> msg=messageDAO.messageList(request);
			model.addAttribute("msg", msg);
		 
		return "message";
	}
}
