package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="utable")
public class Uom {
	
	@Id
	@Column(name="uid")
	@GeneratedValue(generator="uom_gen")
	@GenericGenerator(name="uom_gen", strategy="increment")
	private Integer id;
	
	@Column(name="utype")
	private String type;
	
	@Column(name="model")
	private String model;

	@Column(name="udsc")
	private String dsc;

	
/*	//default constructor
	public Uom() {
		super();
	}

	//parameterized constructor
	public Uom(Integer id, String type, String model, String dsc) {
		super();
		this.id = id;
		this.type = type;
		this.model = model;
		this.dsc = dsc;
	}

*/	//setters and getters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	//toString() method
	@Override
	public String toString() {
		return "Uom [id=" + id + ", type=" + type + ", model=" + model + ", dsc=" + dsc + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsc == null) ? 0 : dsc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uom other = (Uom) obj;
		if (dsc == null) {
			if (other.dsc != null)
				return false;
		} else if (!dsc.equals(other.dsc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	

	
}
