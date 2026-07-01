package com.digicaretaker.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Users {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private int userId;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Column(name = "password", nullable = false)
	    private String password;

	    @Column(name = "phone")
	    private String phone;

	    @Column(name = "gender")
	    private String gender;

	    @Temporal(TemporalType.DATE)
	    @Column(name = "date_of_birth")
	    private Date dateOfBirth;

	    @Column(name = "address")
	    private String address;

	    @ManyToOne
	    @JoinColumn(name = "role_id")
	    private Role role;

	    @Column(name = "status")
	    private String status;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "created_at")
	    private Date createdAt;
	    
	    public Users() {
			// TODO Auto-generated constructor stub
		}

		public Users(int userId, String firstName, String lastName, String email, String password, String phone,
				String gender, Date dateOfBirth, String address, Role role, String status, Date createdAt) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.phone = phone;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.role = role;
			this.status = status;
			this.createdAt = createdAt;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
	    
	    
}
