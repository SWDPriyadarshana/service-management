package com.home.serviceManagement.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Ticket_ApparatusDTO implements Serializable {

	private String ticketId;
	private String apparatusId;
	private String status;
    private Date issduingdate;
    private Date returningDate;
	private BigDecimal fine;
	private int qty;
	
	public Ticket_ApparatusDTO() {
		super();
	}

	public Ticket_ApparatusDTO(String ticketId, String apparatusId, String status, Date issduingdate,
			Date returningDate, BigDecimal fine, int qty) {
		super();
		this.ticketId = ticketId;
		this.apparatusId = apparatusId;
		this.status = status;
		this.issduingdate = issduingdate;
		this.returningDate = returningDate;
		this.fine = fine;
		this.qty = qty;
	}

	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getApparatusId() {
		return apparatusId;
	}
	public void setApparatusId(String apparatusId) {
		this.apparatusId = apparatusId;
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
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setFine(BigDecimal fine) {
		this.fine = fine;
	}
	
	
	@Override
	public String toString() {
		return "Ticket_ApparatusDTO [ticketId=" + ticketId + ", apparatusId=" + apparatusId + ", status=" + status
				+ ", issduingdate=" + issduingdate + ", returningDate=" + returningDate + ", fine=" + fine + ", qty="
				+ qty + "]";
	}
	
	

}
