package com.me.bookstore.pojo;
import javax.persistence.Entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inbox")
public class Inbox {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int msgid;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Profile profile;
	
	private int touser;
	private String msg;
	private Date usertime;
	
	public Inbox() {
		
	}
	
	
	public int getMsgid() {
		return msgid;
	}


	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}


	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	public int getTouser() {
		return touser;
	}


	public void setTouser(int touser) {
		this.touser = touser;
	}


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getUsertime() {
		return usertime;
	}
	public void setUsertime(Date usertime) {
		this.usertime = usertime;
	}
}
