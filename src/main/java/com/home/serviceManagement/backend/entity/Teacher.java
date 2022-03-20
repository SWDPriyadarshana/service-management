package com.home.serviceManagement.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher", indexes = { @Index(columnList = "teacherId", name = "teacherId_index"),
		@Index(columnList = "teacherName", name = "teacherName_index") })

public class Teacher implements Serializable {

	



	/**
	 * 
	 */
	private static final long serialVersionUID = -3581701958867447698L;

	@Id
	@Column(name = "teacherId")
	private String teacherId;

	private String teacherName;
	private String teacherAddress;


	@OneToMany(mappedBy = "teacher", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	
	private List<Ticket> ticketsList = new ArrayList<>();

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}

	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}

	public Teacher() {
		super();
	}

	public Teacher(String teacherId, String teacherName, String teacherAddress) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAddress=" + teacherAddress
				+ "]";
	}

}
