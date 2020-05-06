package com.javabykiran.model;



import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="user_tbl")
public class User {
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	//private State stateObj;
	
	
	
	@Column
	String username;
	@Column
	String mobile;
	@Column
	String email;
	@Column
	String courses;
	@Column
	String gender;
	
	@Column
	String password;
	
	@Column
	private String isDefault="N";
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id_fk",nullable = false)
	private State state; 
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@ColumnDefault("'N'")
	@Column(name="isDefault",nullable = false,length=45)
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public User()
	{
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
