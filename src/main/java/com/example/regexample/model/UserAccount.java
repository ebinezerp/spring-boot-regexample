package com.example.regexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"mobile","email"})})
public class UserAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userAccountId;
	@NotBlank
	@NotNull
	private String email;
	@NotBlank
	@NotNull
	@Pattern(regexp="[a-z]{4,10}",message="Only Small Alphabet. Min 4 and Max 10 characters")
	private String fullName;
	@NotNull
	@NotBlank
	@Pattern(regexp="[0-9]{10,10}",message="Enter Correct Mobile number")
	private String mobile;
	@NotNull
	@NotBlank
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})",
			 message="Min 8 characters, Atleast 1 Capital, 1 Small , 1 Numeric and 1 Special Character")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
