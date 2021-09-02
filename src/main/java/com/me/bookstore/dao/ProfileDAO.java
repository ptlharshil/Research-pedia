package com.me.bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.bookstore.pojo.Profile;

public class ProfileDAO extends AbstractDAO{

	public void createProfile(String name, String uname, String pass,
			String email, String occupation, String aoi, String institution, 
			String[] articlelinks)
	{
		Profile profile= new Profile();
		profile.setName(name);
		profile.setUsername(uname);
		profile.setPassword(pass);
		profile.setEmail(email);
		profile.setOccupation(occupation);
		profile.setAreaofinterest(aoi);
		profile.setInstitution(institution);
		
		List<String> articlelist=new ArrayList<String>();
		
		for(int i=0;i<articlelinks.length;i++) {
			articlelist.add(articlelinks[i]);
		}
		
		profile.setArticles(articlelist);
		begin();
		getSession().save(profile);
		commit();
		
	}
	
	
}
