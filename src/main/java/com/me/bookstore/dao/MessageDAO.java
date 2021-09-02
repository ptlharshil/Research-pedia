package com.me.bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;

import com.me.bookstore.pojo.Inbox;
import com.me.bookstore.pojo.Profile;

public class MessageDAO extends AbstractDAO {

	public Profile getProfile(HttpServletRequest request) {
		HttpSession sess=request.getSession();
		Profile profile= (Profile) sess.getAttribute("profile");
		return profile;
	}
	
	public List<List<Inbox>> messageList(HttpServletRequest request){
		Profile profile=getProfile(request);
		List<List<Inbox>> msg=new ArrayList<List<Inbox>>();
		List<Profile> pl= getSession().createQuery("from Profile").list();
		
		for(Profile p:pl)
		{
			
			Query qry=getSession().createQuery("from Inbox where (profile.id= :from and touser= :to) or (profile.id= :to and touser= :from) order by usertime");
			qry.setParameter("from", profile.getId());
			qry.setParameter("to", p.getId());
			msg.add((ArrayList<Inbox>) qry.list());
			
		}
		return msg;
	}
}
