package com.home.serviceManagement.backend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "apparatusId")
public class Test_Apparatus extends Apparatus {
	private String testName;

	public Test_Apparatus() {
		super();
	}
	
	

	public Test_Apparatus(String testName) {
		super();
		this.testName = testName;
	}



	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}



	@Override
	public String toString() {
		return "Test_Apparatus [testName=" + testName + "]";
	}
	
	 
	
}
