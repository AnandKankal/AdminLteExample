package com.javabykiran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.LoginDao;
import com.javabykiran.dao.RegisterDao;
import com.javabykiran.model.Users;

@Service
public class RegisterService {
	@Autowired
	RegisterDao registerDao;

	public void registerUser(Users user) {
		System.out.println("registerUser service");
		registerDao.registerUser(user);
		
	}


}
