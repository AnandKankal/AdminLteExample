package com.javabykiran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operators")
public class Operators {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column
	String person;
	
	@Column
	String forr;
	
			
	@Column		
	String whatsapp;
	
	@Column
	String phonecall;
	
	@Column
	String sms;
	
	@Column
	String email;
	
	@Column
	String contact;
	
	@Column
	String timing;
	

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getForr() {
		return forr;
	}

	public void setForr(String forr) {
		this.forr = forr;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getPhonecall() {
		return phonecall;
	}

	public void setPhonecall(String phonecall) {
		this.phonecall = phonecall;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
