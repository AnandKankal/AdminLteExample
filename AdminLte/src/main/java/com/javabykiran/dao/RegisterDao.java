package com.javabykiran.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.model.Users;

@Repository
public class RegisterDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void registerUser(Users user) {
		Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
        session.beginTransaction();
        session.save(user);
        //Commit the transaction
        tx.commit();
        System.out.println("registerUser dao");
        session.close();
        
	}
	

}
