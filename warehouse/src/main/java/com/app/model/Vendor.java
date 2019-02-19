package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vendor {

	
	@Id
	@GeneratedValue(generator="item_gen")
	@GenericGenerator(name="item_gen", strategy="increment")
	@Column(name="vid")
	private Integer id;
	@Column(name="code")
	private String venCode;
	@Column(name="name")
	private String venName;
	@Column(name="desg")
	private String venDesg;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="venPreserve",joinColumns=@JoinColumn(name="vid"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> venPreserve;

	public Vendor() {
		super();
	}

	public Vendor(Integer id, String venCode, String venName, String venDesg, List<String> venPreserve) {
		super();
		this.id = id;
		this.venCode = venCode;
		this.venName = venName;
		this.venDesg = venDesg;
		this.venPreserve = venPreserve;
	}

	
	public Vendor(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVenCode() {
		return venCode;
	}

	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenDesg() {
		return venDesg;
	}

	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}

	public List<String> getVenPreserve() {
		return venPreserve;
	}

	public void setVenPreserve(List<String> venPreserve) {
		this.venPreserve = venPreserve;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", venCode=" + venCode + ", venName=" + venName + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}

	
	
}
