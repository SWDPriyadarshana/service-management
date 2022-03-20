package com.home.serviceManagement.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket_Appratus implements Serializable{
	
	@EmbeddedId
	private Ticket_Apparatus_PK ticket_Apparatus_PK;
	private String status;
	
	@Temporal(TemporalType.DATE)
	private Date issduingdate;
	@Temporal(TemporalType.DATE)
	private Date returningDate;
	private BigDecimal fine;
	private int qty;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="ticketId",name="ticketId",insertable=false,updatable=false)
	private Ticket ticket;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="apparatusId",name="apparatusId",insertable=false,updatable=false)
	private Apparatus apparatus;

	public Ticket_Appratus() {
		super();
	}

	
	
	public Ticket_Appratus(Ticket_Apparatus_PK ticket_Apparatus_PK, String status, Date issduingdate,
			Date returningDate, BigDecimal fine, int qty, Ticket ticket, Apparatus apparatus) {
		super();
		this.ticket_Apparatus_PK = ticket_Apparatus_PK;
		this.status = status;
		this.issduingdate = issduingdate;
		this.returningDate = returningDate;
		this.fine = fine;
		this.qty = qty;
		this.ticket = ticket;
		this.apparatus = apparatus;
	}





	public Ticket_Appratus(String ticketId,String apparatusId, String status, Date issduingdate,
			Date returningDate, BigDecimal fine, int qty, Ticket ticket, Apparatus apparatus) {
		super();
		this.ticket_Apparatus_PK = new Ticket_Apparatus_PK(ticketId,apparatusId);
		this.status = status;
		this.issduingdate = issduingdate;
		this.returningDate = returningDate;
		this.fine = fine;
		this.qty = qty;
		this.ticket = ticket;
		this.apparatus = apparatus;
	}



	public Ticket_Apparatus_PK getTicket_Apparatus_PK() {
		return ticket_Apparatus_PK;
	}

	public void setTicket_Apparatus_PK(Ticket_Apparatus_PK ticket_Apparatus_PK) {
		this.ticket_Apparatus_PK = ticket_Apparatus_PK;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getIssduingdate() {
		return issduingdate;
	}

	public void setIssduingdate(Date issduingdate) {
		this.issduingdate = issduingdate;
	}

	public Date getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}

	public BigDecimal getFine() {
		return fine;
	}

	public void setFine(BigDecimal fine) {
		this.fine = fine;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Apparatus getApparatus() {
		return apparatus;
	}

	public void setApparatus(Apparatus apparatus) {
		this.apparatus = apparatus;
	}
	
	

	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	@Override
	public String toString() {
		return "Ticket_Appratus [ticket_Apparatus_PK=" + ticket_Apparatus_PK + ", status=" + status + ", issduingdate="
				+ issduingdate + ", returningDate=" + returningDate + ", fine=" + fine + ", qty=" + qty + ", ticket="
				+ ticket + ", apparatus=" + apparatus + "]";
	}



	
	

}
