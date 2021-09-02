package com.me.bookstore.dao;
import java.util.List;
import org.hibernate.query.Query;
import com.me.bookstore.pojo.Post;
import com.me.bookstore.pojo.Profile;

public class LoginDAO extends AbstractDAO {

	public Profile signin(String username) {
		Profile pl=null;
		
		pl=(Profile) getSession().createQuery("from Profile where username=:username ").setParameter("username", username).uniqueResult();
		return pl;
	}
	
	public List<Post> allPosts() {
		Query query=getSession().createQuery("from Post order by posttime desc");
		List<Post> allposts =query.list();
		return allposts;
	}
}
