package com.me.bookstore.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO {
	
//	public Session getSession() {
//		Configuration cfg=new Configuration();
//		SessionFactory sf=cfg.configure("hibernate.cfg.xml").buildSessionFactory();
//		Session session=sf.openSession();
//		return session;
//	}
	
	private static final Logger log = Logger.getAnonymousLogger();
    
	private static final ThreadLocal sessionThread = new ThreadLocal();
    
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    protected AbstractDAO() {
    }

    public static Session getSession()
    {
        Session session = (Session) AbstractDAO.sessionThread.get();
        
        if (session == null)
        {
            session = sessionFactory.openSession();
            AbstractDAO.sessionThread.set(session);
        }
        return session;
    }
   protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        AbstractDAO.sessionThread.set(null);
    }

    public static void close() {
        getSession().close();
        AbstractDAO.sessionThread.set(null);
   }
	
}
