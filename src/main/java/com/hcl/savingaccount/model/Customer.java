package com.hcl.savingaccount.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="customerId")
	private long customerId;
	@Column(name="firstName",nullable=false)
	private String firstName;
	@Column(name="lastName",nullable=false)
	private String lastName;
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(nullable=false)
	private int password;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String occupation;
	@Column(unique=true)
	private String aadhar;
	@Column(name="PAN",unique=true)
	private String PAN;
	@Column(nullable=false)
	private double salary;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String pinCode;
	 @Enumerated(EnumType.STRING)
	private Gender gender;
	 @Temporal(TemporalType.DATE)
	 @Column(name="dateOfBirth")
	private Date dateOfBirth;
	 @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "customer")
	 //@JsonIgnore
	private Account account;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer(String firstName, String lastName, String email, String occupation, String aadhar, String pAN,
			double salary, String address, String pinCode, Gender gender, Date dateOfBirth, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.occupation = occupation;
		this.aadhar = aadhar;
		PAN = pAN;
		this.salary = salary;
		this.address = address;
		this.pinCode = pinCode;
		this.gender = gender;
		
		this.dateOfBirth = dateOfBirth;
		this.account = account;
	}
	
	public Customer(long customerId, int password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", email=" + email + ", occupation=" + occupation + ", aadhar=" + aadhar
				+ ", PAN=" + PAN + ", salary=" + salary + ", address=" + address + ", pinCode=" + pinCode + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", account=" + account + "]";
	}

	

}
