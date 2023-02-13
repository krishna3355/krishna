package com.slokam.helthcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String speci;
	
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", speci=" + speci + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeci() {
		return speci;
	}
	public void setSpeci(String speci) {
		this.speci = speci;
	}
	
	
}
