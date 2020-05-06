package com.javabykiran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="state_master")
public class State {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int state_id;
	
	@Column
	String state;
	
	
	
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", state=" + state + "]";
	}
	
	

}
