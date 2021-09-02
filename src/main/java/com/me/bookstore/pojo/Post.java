package com.me.bookstore.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postid;
	private String nameofuser;
	private String aoi;
	private String description;
	private String url;
	private Date posttime;
	
	public Post() {
		
	}



	public Date getPosttime() {
		return posttime;
	}


	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}


	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getNameofuser() {
		return nameofuser;
	}

	public void setNameofuser(String nameofuser) {
		this.nameofuser = nameofuser;
	}

	public String getAoi() {
		return aoi;
	}

	public void setAoi(String aoi) {
		this.aoi = aoi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
