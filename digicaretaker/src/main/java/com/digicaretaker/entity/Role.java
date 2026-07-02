package com.digicaretaker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "roles")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
	 private int role_id;
	
	 @Column(name = "role_name", nullable = false, unique = true)
	 private String role_name;
	 
	 public Role() {
		// TODO Auto-generated constructor stub
	}

	 public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	 }
	 
	 public Role(int role_id) {
		 this.role_id = role_id;
	 }

	 public int getRole_id() {
		 return role_id;
	 }

	 public void setRole_id(int role_id) {
		 this.role_id = role_id;
	 }

	 public String getRole_name() {
		 return role_name;
	 }

	 public void setRole_name(String role_name) {
		 this.role_name = role_name;
	 }
	 
	 @Override
	    public String toString() {
	        return "Role [roleId=" + role_id + ", roleName=" + role_name + "]";
	    }
}
