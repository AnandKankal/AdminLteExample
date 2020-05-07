package com.javabykiran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.model.Download;
import com.javabykiran.model.Links;
import com.javabykiran.model.Operators;
import com.javabykiran.model.State;
import com.javabykiran.model.User;
import com.javabykiran.model.Users;	
import com.javabykiran.service.LoginService;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Users> loadUser() {
		List<Users> listusers = (List<Users>) sessionFactory
		.openSession()
		.createCriteria(Users.class).list();
		return listusers;
	}
	
	public List<User> showUser() {
		List<User> listusers = (List<User>) sessionFactory
		.openSession()
		.createCriteria(User.class).list();
		return listusers;
	}
	
	public void add(User user) {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
        session.beginTransaction();
        session.save(user);
        //Commit the transaction
        tx.commit();
        System.out.println("add user dao");
        session.close();
	}
	
	public User getEmpById(int id)
	{
		//Session session = sessionFactory.openSession(); 
		return (User) sessionFactory.openSession().get(
                User.class, id);
	}
	
	public User updateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		
        
        return user;
    }
	public User update(User users) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(users);
		tx.commit();
		return users;
	}
	
	public User addUser(User users) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(users);
		transaction.commit();
		return users;
		
	}
	
	public void saveOrUpdate(User user) {

		if (getEmpById(user.getUserid())==null) {
			Session session = sessionFactory.openSession();
			session.save(user);
		} else {
			Session session = sessionFactory.openSession();
			
			session.update(user);
		}

	}
	public User getUsers(int id) {
		return (User) sessionFactory.openSession().get(User.class, id);

	}
	
	public void deleteUser(int userId) {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
	      User user = session.byId(User.class).load(userId);
	      session.delete(user);
	      transaction.commit(); 
    }
	
	//new code
	public void addNewUser(User user) {   
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
       session.beginTransaction();
       session.save(user);
      
       //Commit the transaction
       tx.commit();
       System.out.println("add user dao");
       session.close(); 
       
       //sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
	
	
	public void deleteAll(int[] ids) {
		 Session session = sessionFactory.openSession();
		 for (int i = 0; i < ids.length; i++) {
			 Transaction transaction = session.beginTransaction();
		      User user = session.byId(User.class).load(ids[i]);
		      session.delete(user);
		      transaction.commit();
		}
		  
   }
	
	public List<State> getAllStates() {
		List<State> listStates = (List<State>) sessionFactory
		.openSession()
		.createCriteria(State.class).list();
		return listStates;
	}
	
	public State getStateById(int stat_id)
	{
		return (State) sessionFactory.openSession().get(
                State.class, stat_id);
	}
	
	public List<Download> showDownloadList() {
		List<Download> listusers = (List<Download>) sessionFactory
		.openSession()
		.createCriteria(Download.class).list();
		
		return listusers;
	}
	
	public List<Links> showLinkList() {
		List<Links> listusers = (List<Links>) sessionFactory
		.openSession()
		.createCriteria(Links.class).list();
		
		return listusers;
	}
	
	public List<Operators> showOperators() {
		List<Operators> listusers = (List<Operators>) sessionFactory
		.openSession()
		.createCriteria(Operators.class).list();
		
		return listusers;
	}

}
