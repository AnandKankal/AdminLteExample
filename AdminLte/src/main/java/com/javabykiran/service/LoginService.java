package com.javabykiran.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.LoginDao;
import com.javabykiran.model.Users;

@Service // @Component//@Cpnfiguration
public class LoginService {

	@Autowired
	LoginDao loginDao;

	public Users checkLogin(Users user) {
		Users user2 = loginDao.checkUser(user);
		if (user2 != null) {
			return user2;
		} else {
			return null;
		}
	}

	public ArrayList<Users> loadUsers() {
		return (ArrayList<Users>) loginDao.loadUser();
	}
}
