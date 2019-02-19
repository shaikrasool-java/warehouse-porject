package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {
	

	@Id
	@GeneratedValue(generator="cust_gen")
	@GenericGenerator(name="cust_gen", strategy="increment")
	
	private Integer cId;
	private String custName;
	private String custEmail;
	private String custContact;
	private String  custAddr;
	private String custLocs;
	private String custEnabled;
	private String custCode;
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustContact() {
		return custContact;
	}
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public String getCustLocs() {
		return custLocs;
	}
	public void setCustLocs(String custLocs) {
		this.custLocs = custLocs;
	}
	public String getCustEnabled() {
		return custEnabled;
	}
	public void setCustEnabled(String custEnabled) {
		this.custEnabled = custEnabled;
	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", custName=" + custName + ", custEmail=" + custEmail + ", custContact="
				+ custContact + ", custAddr=" + custAddr + ", custLocs=" + custLocs + ", custEnabled=" + custEnabled
				+ ", custCode=" + custCode + "]";
	}
	public Customer() {
		super();
	}
	public Customer(Integer cId, String custName, String custEmail, String custContact, String custAddr,
			String custLocs, String custEnabled, String custCode) {
		super();
		this.cId = cId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custContact = custContact;
		this.custAddr = custAddr;
		this.custLocs = custLocs;
		this.custEnabled = custEnabled;
		this.custCode = custCode;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
		
}
