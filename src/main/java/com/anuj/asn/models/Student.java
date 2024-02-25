package com.anuj.asn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Student")
@Getter
public class Student {

	
	
	

	@NotBlank(message = "Username is required")
	@Column(name = "user_name")
	private String userName;

	@NotBlank(message = "Password is required")
	@Column(name = "password")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and have a minimum length of 8 characters")
	private String password;

	@NotBlank(message = "First name is required")
	@Column(name = "firstname")
	private String firstname;

	@NotBlank(message = "Last name is required")
	@Column(name = "lastname")
	private String lastname;

	@NotBlank(message = "Address is required")
	@Column(name = "address")
	private String address;

	@NotBlank(message = "Address is required")
	@Column(name = "city")
	private String city;

	@NotBlank(message = "Postal code is required")
	@Column(name = "postal_code")
	private String postal_code;

	@Id
	@Column(name = "student_id ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId; //



	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public int getstudentId() {
		return studentId;
	}

	public void setstudentId(int studentId) {
		this.studentId = studentId;
	}

	public Student(String firstname, String lastname, String address, String city, String postal_code, int studentId) {
		super();

		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.postal_code = postal_code;
		this.studentId = studentId;
	}

	
	public Student(String address, String city, String firstname, String lastname, String password, String postal_code, int studentId, String userName) {
		super();

		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.postal_code = postal_code;
		this.studentId = studentId;
		this.userName=userName;

	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	

}
