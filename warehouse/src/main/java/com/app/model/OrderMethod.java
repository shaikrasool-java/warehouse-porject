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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="OrderTable")
public class OrderMethod {
 
	@Id
	@Column(name="oid")
	@GeneratedValue(generator="order_gen")
	@GenericGenerator(name="order_gen", strategy="increment")
	private Integer id;
	
	private String mode;
	
	private String code;
	
	private String method;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="accept", joinColumns=@JoinColumn(name="oid"))
	@OrderColumn(name="pos")
	@Column(name="data")	
	private List<String> accept;
	
	@Column(name="description")
	private String dsc;

	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}

	public OrderMethod(Integer id, String mode, String code, String method, List<String> accept, String dsc) {
		super();
		this.id = id;
		this.mode = mode;
		this.code = code;
		this.method = method;
		this.accept = accept;
		this.dsc = dsc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<String> getAccept() {
		return accept;
	}

	public void setAccept(List<String> accept) {
		this.accept = accept;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", mode=" + mode + ", code=" + code + ", method=" + method + ", accept="
				+ accept + ", dsc=" + dsc + "]";
	}
	

	
}
