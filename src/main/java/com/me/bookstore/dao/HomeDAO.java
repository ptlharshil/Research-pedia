package com.me.bookstore.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.query.Query;

import com.me.bookstore.pojo.Inbox;
import com.me.bookstore.pojo.Post;
import com.me.bookstore.pojo.Profile;

public class HomeDAO extends AbstractDAO {

	public Profile getProfile(HttpServletRequest request) {
		HttpSession sess=request.getSession();
		Profile profile= (Profile) sess.getAttribute("profile");
		return profile;
	}
	public void newPost(String aoi,String articleurl, String description, HttpServletRequest request) {
		
		
		Profile profile=getProfile(request);
		Post post=new Post();
		post.setNameofuser(profile.getName());
		post.setAoi(aoi);
		post.setUrl(articleurl);
		post.setDescription(description);
		post.setPosttime(new Date());
		
		begin();
		getSession().save(post);
		commit();
	}
	
	public ArrayList<Post> searchPosts(String area){
		Query query= getSession().createQuery("from Post where aoi= :area order by posttime desc");
		query.setParameter("area", area);
		List<Post> aoiposts =query.list();
		
		return (ArrayList<Post>) aoiposts;
	}
	
	public ArrayList<Profile> profileSearch(String search){
		Query query= getSession().createQuery("from Profile where name= :search");
		query.setParameter("search", search);
		List<Profile> prof=query.list();
		
		return (ArrayList<Profile>) prof;
	}
	
	public void message(HttpServletRequest request,String message, String recipient) {
		Profile profile=getProfile(request);
		int userid=0;
		Inbox msg=new Inbox();
		msg.setProfile(profile);
		msg.setMsg(message);
		msg.setUsertime(new Date());
		Query qy= getSession().createQuery("from Profile where name= :recipient");
		qy.setParameter("recipient", recipient);
		List<Profile> pl=qy.list();
		for(Profile p:pl)
		{
			userid=p.getId();
		}
	
		msg.setTouser(userid);
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ptlhld@gmail.com", "PasswordDemo1234@"));
		email.setSSLOnConnect(true);
		try {
			email.setFrom("ptlhld@gmail.com");
			email.setSubject("Research-pedia: You have a new message");
			email.setMsg("Hello, Please check your inbox on Research-pedia, you have a message waiting. Thank you, Research-pedia");
			email.addTo("ptlharshil3695@gmail.com");
			email.send();
		} catch (EmailException e) {
		
			e.printStackTrace();
		}
		
		
		begin();
		getSession().save(msg);
		commit();
		
	}
}
