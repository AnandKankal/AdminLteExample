package com.javabykiran.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabykiran.model.Users;

@Repository
public class LoginDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Users checkUser(Users user) {
		/*
		 * System.out.println("gdhgsjgdjs"); List<User> listusers = (List<User>)
		 * sessionFactory.getCurrentSession().createCriteria(User.class)
		 * .add(Expression.eq("username", user.getUsername()));
		 * System.out.println(user.getUsername()); if (!listusers.isEmpty()) { return
		 * listusers.get(0); } return null;
		 */
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("FROM Users U WHERE U.username=:username AND U.password=:password");
		q.setParameter("username", user.getUsername());
		q.setParameter("password", user.getPassword());
		
		List<Users> listusers = q.list();
		if (!listusers.isEmpty()) {
			return listusers.get(0); 
			} 
		return null;
	}

	public List<Users> loadUser() {
		List<Users> listusers = (List<Users>) sessionFactory
		.openSession()
		.createCriteria(Users.class).list();
		return listusers;
	}
}









