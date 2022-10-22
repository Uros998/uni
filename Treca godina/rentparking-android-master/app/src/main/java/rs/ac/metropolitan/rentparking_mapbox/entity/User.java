package rs.ac.metropolitan.rentparking_mapbox.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.*;
public class User implements Serializable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("firstName")
	private String firstName;
	@SerializedName("lastName")
	private String lastName;
	@SerializedName("email")
	private String email;
	@SerializedName("username")
	private String username;
	@SerializedName("password")
	private String password;
	@SerializedName("profPic")
	private String profPic;
	@SerializedName("cvv")
	private String cvv;
	@SerializedName("bankAccount")
	private String bankAccount;
	@SerializedName("bankName")
	private String bankName;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getProfPic() {
		return profPic;
	}

	public void setProfPic(String profPic) {
		this.profPic = profPic;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", profPic='" + profPic + '\'' +
				", cvv='" + cvv + '\'' +
				", bankAccount='" + bankAccount + '\'' +
				", bankName='" + bankName + '\'' +
				'}';
	}
}