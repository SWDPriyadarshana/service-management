package com.home.serviceManagement.backend.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Ticket_Apparatus_PK implements Serializable {

	private String ticketId;
	private String apparatusId;

	public Ticket_Apparatus_PK() {
		super();
	}

	public Ticket_Apparatus_PK(String ticketId, String apparatusId) {
		super();
		this.ticketId = ticketId;
		this.apparatusId = apparatusId;
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

	@Override
	public String toString() {
		return "Ticket_Apparatus_PK [ticketId=" + ticketId + ", apparatusId=" + apparatusId + "]";
	}

}
