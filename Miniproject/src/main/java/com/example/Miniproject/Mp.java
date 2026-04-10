package com.example.Miniproject;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Mp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String fname;
	@Column(unique = true)
	String email;
	String Pass;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public Mp(int id, String fname, String email, String pass) {
		super();
		this.id = id;
		this.fname = fname;
		this.email = email;
		Pass = pass;
	}
	public Mp() {
		super();
		// TODO Auto-generated constructor stub
	}

}
