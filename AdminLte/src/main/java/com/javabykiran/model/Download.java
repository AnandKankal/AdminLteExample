package com.javabykiran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="download_list")
public class Download {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column
	byte[] name;
	@Column
	String vendor;
	@Column
	String version;
	@Column
	String bit_32;
	@Column
	String bit_64;
	@Column
	String common;
	@Column
	String officialsources;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getName() {
		return name;
	}
	public void setName(byte[] name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBit_32() {
		return bit_32;
	}
	public void setBit_32(String bit_32) {
		this.bit_32 = bit_32;
	}
	public String getBit_64() {
		return bit_64;
	}
	public void setBit_64(String bit_64) {
		this.bit_64 = bit_64;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public String getOfficialsources() {
		return officialsources;
	}
	public void setOfficialsources(String officialsources) {
		this.officialsources = officialsources;
	}
	
}
