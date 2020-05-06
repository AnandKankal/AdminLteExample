package com.javabykiran.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.LoginDao;
import com.javabykiran.dao.UserDao;
import com.javabykiran.model.State;
import com.javabykiran.model.User;
import com.javabykiran.model.Users;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public ArrayList<Users> loadUsers() {
		return (ArrayList<Users>) userDao.loadUser();
	}
	
	public ArrayList<User> showUsers() {
		return (ArrayList<User>) userDao.showUser();
	}
	
	public void add(User user) {
		System.out.println("registerUser service");
		userDao.add(user);
	}
	
	public User getEmpById(int id)
	{
		User  u = userDao.getEmpById(id);
		return u;
	}
	
	public User getByID(int id) {
		return userDao.getUsers(id);
	}
	
	public void update(User users) {
		userDao.update(users);
	}
	
	public User addUser(User users)
	{
		
		return userDao.addUser(users);
		
		
	}
	
	public User updateUser(User user) {
        // TODO Auto-generated method stub
        return userDao.update(user);
    }
	
	public void saveOrUpdate(User user) 
	{
		userDao.saveOrUpdate(user);
	}
	
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
    }
	
	//new code
	public void addNewUser(User user)
	{
		 userDao.addNewUser(user);
	}
	
	
	public void deleteAll(int[] ids) {
		userDao.deleteAll(ids);
    }
	
	
	public List<State> getAllStates() {
		return (ArrayList<State>) userDao.getAllStates();
	}
	
	public State getStateById(int stat_id)
	{
		return  userDao.getStateById(stat_id);
	}
}
