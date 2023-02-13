package com.slokam.helthcare.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="visiting")
public class Visiting {

	
	@Override
	public String toString() {
		return "Visiting [id=" + id + ", time=" + time + ", doctor=" + doctor + ", appointment=" + appointment + "]";
	}
	@Id
	@GeneratedValue
	private Integer id;
	private Date time;
	@OneToOne
	@JoinColumn(name="did")
	private Doctor doctor;
	@OneToOne
	@JoinColumn(name="fkaid")
	private Appointment appointment;
	
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
