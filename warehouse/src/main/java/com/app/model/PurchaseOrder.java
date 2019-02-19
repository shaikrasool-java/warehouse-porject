package com.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PurchaseOrder {


	@ManyToOne
	@JoinColumn(name="shipId")
	private ShipmentType shipment;

	@ManyToOne
	@JoinColumn(name="vId")
	private WhUserType ven;
	
	@Id
	@Column(name="poid")
	@GeneratedValue(generator="pid")
	@GenericGenerator(name="pid", strategy="increment")
	private Integer id;
	private String code;
	private String refNum;
	private String qa;
	private String status;
	private String dsc;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}

	public PurchaseOrder(ShipmentType shipment, WhUserType ven, Integer id, String code, String refNum, String qa,
			String status, String dsc) {
		super();
		this.shipment = shipment;
		this.ven = ven;
		this.id = id;
		this.code = code;
		this.refNum = refNum;
		this.qa = qa;
		this.status = status;
		this.dsc = dsc;
	}

	public ShipmentType getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentType shipment) {
		this.shipment = shipment;
	}

	public WhUserType getVen() {
		return ven;
	}

	public void setVen(WhUserType ven) {
		this.ven = ven;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [shipment=" + shipment + ", ven=" + ven + ", id=" + id + ", code=" + code + ", refNum="
				+ refNum + ", qa=" + qa + ", status=" + status + ", dsc=" + dsc + "]";
	}
		
}
