package com.home.serviceManagement.backend.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.home.serviceManagement.backend.entity.Ticket_Appratus;

public class ApparatusDTO implements Serializable {

	private String apparatusId;
	private String apparatusName;
	private int apparatusCount;
	private String apparatusType;
	private BigDecimal apparatusPrice;
	private String warrenty;
	private int warrentyPeriod;
	private String testName;

	public ApparatusDTO() {
		super();
	}

	

	public ApparatusDTO(String apparatusId, String apparatusName, int apparatusCount, String apparatusType,
			BigDecimal apparatusPrice, String warrenty, int warrentyPeriod, String testName) {
		super();
		this.apparatusId = apparatusId;
		this.apparatusName = apparatusName;
		this.apparatusCount = apparatusCount;
		this.apparatusType = apparatusType;
		this.apparatusPrice = apparatusPrice;
		this.warrenty = warrenty;
		this.warrentyPeriod = warrentyPeriod;
		this.testName = testName;
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
	
	

	public String getTestName() {
		return testName;
	}



	public void setTestName(String testName) {
		this.testName = testName;
	}



	@Override
	public String toString() {
		return "ApparatusDTO [apparatusId=" + apparatusId + ", apparatusName=" + apparatusName + ", apparatusCount="
				+ apparatusCount + ", apparatusType=" + apparatusType + ", apparatusPrice=" + apparatusPrice
				+ ", warrenty=" + warrenty + ", warrentyPeriod=" + warrentyPeriod + ", testName=" + testName + "]";
	}



	

}
