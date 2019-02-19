package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {


	@ManyToOne
	@JoinColumn(name="uomfk")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name="om_Sale_Id")
	private OrderMethod saleType;

	@ManyToOne
	@JoinColumn(name="om_Purchase_Id")
	private OrderMethod purchaseType;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_venusr_tab",
	joinColumns=@JoinColumn(name="itmaIdFk"),
	inverseJoinColumns=@JoinColumn(name="venIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> venUsers=new ArrayList<WhUserType>(0);



	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_custs_tab",
	joinColumns=@JoinColumn(name="itmbIdFk"),
	inverseJoinColumns=@JoinColumn(name="custIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> custUsers=new ArrayList<WhUserType>(0);


	@Id
	@GeneratedValue(generator="item_gen")
	@GenericGenerator(name="item_gen", strategy="increment")
	@Column(name="id")
	private Integer id;
	@Column(unique=true)
	private String icode;
	private double cost;
	private String currency;
	private double width;
	private double height;
	private double length;
	private String dsc;
/*

	public Item() {
		super();
	}
*/

/*	public Item(Integer id) {
		super();
		this.id = id;
	}
*/
/*
	public Item(Uom uom, OrderMethod saleType, OrderMethod purchaseType, List<WhUserType> venUsers,
			List<WhUserType> custUsers, Integer id, String icode, double cost, String currency, double width,
			double height, double length, String dsc) {
		super();
		this.uom = uom;
		this.saleType = saleType;
		this.purchaseType = purchaseType;
		this.venUsers = venUsers;
		this.custUsers = custUsers;
		this.id = id;
		this.icode = icode;
		this.cost = cost;
		this.currency = currency;
		this.width = width;
		this.height = height;
		this.length = length;
		this.dsc = dsc;
	}
*/

	public Uom getUom() {
		return uom;
	}


	public void setUom(Uom uom) {
		this.uom = uom;
	}


	public OrderMethod getSaleType() {
		return saleType;
	}


	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}


	public OrderMethod getPurchaseType() {
		return purchaseType;
	}


	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}


	public List<WhUserType> getVenUsers() {
		return venUsers;
	}


	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}


	public List<WhUserType> getCustUsers() {
		return custUsers;
	}


	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getIcode() {
		return icode;
	}


	public void setIcode(String icode) {
		this.icode = icode;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public String getDsc() {
		return dsc;
	}


	public void setDsc(String dsc) {
		this.dsc = dsc;
	}


	@Override
	public String toString() {
		return "Item [uom=" + uom + ", saleType=" + saleType + ", purchaseType=" + purchaseType + ", venUsers="
				+ venUsers + ", custUsers=" + custUsers + ", id=" + id + ", icode=" + icode + ", cost=" + cost
				+ ", currency=" + currency + ", width=" + width + ", height=" + height + ", length=" + length + ", dsc="
				+ dsc + "]";
	}

}

