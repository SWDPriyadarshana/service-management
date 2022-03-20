package com.home.serviceManagement.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket implements Serializable {

	@Id
	private String ticketId;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "teacherId", name = "teacherId")
	private Teacher teacher;
	
	@OneToMany(mappedBy="ticket",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Ticket_Appratus> ticket_Appratus=new ArrayList<>();
	
	

	public List<Ticket_Appratus> getTicket_Appratus() {
		return ticket_Appratus;
	}

	public void setTicket_Appratus(List<Ticket_Appratus> ticket_Appratus) {
		this.ticket_Appratus = ticket_Appratus;
	}

	public Ticket() {
		super();
	}

	

	public Ticket(String ticketId, Date date, Teacher teacher, List<Ticket_Appratus> ticket_Appratus) {
		super();
		this.ticketId = ticketId;
		this.date = date;
		this.teacher = teacher;
		this.ticket_Appratus = ticket_Appratus;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", date=" + date + ", teacher=" + teacher + ", ticket_Appratus="
				+ ticket_Appratus + "]";
	}

}
