package com.me.bookstore.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="profile")
public class Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private String password;
	private String name;
	private String occupation;
	private String areaofinterest;
	private String institution;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> articles=new ArrayList<String>();
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String , String> msg=new HashMap<String, String>();
	
	public Profile() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAreaofinterest() {
		return areaofinterest;
	}

	public void setAreaofinterest(String areasofinterest) {
		this.areaofinterest = areasofinterest;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public List<String> getArticles() {
		return articles;
	}

	public void setArticles(List<String> articles) {
		this.articles = articles;
	}

	public Map<String, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}

	

	
	
	
}
