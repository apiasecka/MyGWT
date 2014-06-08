package com.project.gwt.shared;

import java.io.Serializable;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private	String adress;
	private String phone;
	private String picture;
	
	public Data(){};
	
	public Data(String name, String adress, String phone, String email, String picture) {
		this.name = name;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.picture = picture;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
