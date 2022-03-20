package com.home.serviceManagement.backend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Electrical_Apparatus.java - this entity expose the Electrical_Apparatus table
 * 
 * @author Ranga Lankathilaka
 * @version 1.0
 * @see Apparatus
 */
@Entity
@PrimaryKeyJoinColumn(name = "apparatusId")
public class Electrical_Apparatus extends Apparatus {

	private String warrenty;
	private int warrentyPeriod;

	public Electrical_Apparatus() {
		super();
	}

	public Electrical_Apparatus(String warrenty, int warrentyPeriod) {
		super();
		this.warrenty = warrenty;
		this.warrentyPeriod = warrentyPeriod;
	}

	public String getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}

	public int getWarrentyPeriod() {
		return warrentyPeriod;
	}

	public void setWarrentyPeriod(int warrentyPeriod) {
		this.warrentyPeriod = warrentyPeriod;
	}

	@Override
	public String toString() {
		return "Electrical_Apparatus [warrenty=" + warrenty + ", warrentyPeriod=" + warrentyPeriod + "]";
	}

}
