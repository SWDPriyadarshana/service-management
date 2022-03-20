package com.home.serviceManagement.backend.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Apparatus.java - this entity expose the apparatus table
 * 
 * @author Ranga Lankathilaka
 * @version 1.0
 * 
 */

@Entity
@Table(name = "Apparatus")
@Inheritance(strategy = InheritanceType.JOINED)
public class Apparatus implements Serializable {

	private static final long serialVersionUID = -5094252394390263312L;
	@Id
	@Column(name = "apparatusId")
	private String apparatusId;
	private String apparatusName;
	private int apparatusCount;
	private String apparatusType;
	private BigDecimal apparatusPrice;
	

	@OneToMany(mappedBy = "apparatus", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<Ticket_Appratus> ticket_Appratus = new ArrayList<>();

	/**
	 * Retrieve the value of Ticket_Appratus.
	 * 
	 * @return A List of ticket_Appratus.
	 */

	public List<Ticket_Appratus> getTicket_Appratus() {
		return ticket_Appratus;
	}

	/**
	 * Set the value of ticket_Appratus.
	 * 
	 * @param ticket_Appratus A variable of type List.
	 */
	public void setTicket_Appratus(List<Ticket_Appratus> ticket_Appratus) {
		this.ticket_Appratus = ticket_Appratus;
	}

	public Apparatus() {
		super();
	}

	public Apparatus(String apparatusId, String apparatusName, int apparatusCount, String apparatusType,
			BigDecimal apparatusPrice) {
		super();
		this.apparatusId = apparatusId;
		this.apparatusName = apparatusName;
		this.apparatusCount = apparatusCount;
		this.apparatusType = apparatusType;
		this.apparatusPrice = apparatusPrice;
	}

	public String getApparatusId() {
		return apparatusId;
	}

	public void setApparatusId(String apparatusId) {
		this.apparatusId = apparatusId;
	}

	public String getApparatusName() {
		return apparatusName;
	}

	public void setApparatusName(String apparatusName) {
		this.apparatusName = apparatusName;
	}

	public int getApparatusCount() {
		return apparatusCount;
	}

	public void setApparatusCount(int apparatusCount) {
		this.apparatusCount = apparatusCount;
	}

	public String getApparatusType() {
		return apparatusType;
	}

	public void setApparatusType(String apparatusType) {
		this.apparatusType = apparatusType;
	}

	public BigDecimal getApparatusPrice() {
		return apparatusPrice;
	}

	public void setApparatusPrice(BigDecimal apparatusPrice) {
		this.apparatusPrice = apparatusPrice;
	}

	@Override
	public String toString() {
		return "Apparatus [apparatusId=" + apparatusId + ", apparatusName=" + apparatusName + ", apparatusCount="
				+ apparatusCount + ", apparatusType=" + apparatusType + ", apparatusPrice=" + apparatusPrice + "]";
	}

}
