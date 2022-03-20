package com.home.serviceManagement.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TeacherDTO implements Serializable {
	private String teacherId;
	private String teacherName;
	private String teacherAddress;
	private List<TicketDTO> ticketList = new ArrayList<>();

	public TeacherDTO() {
		super();
	}

	public TeacherDTO(String teacherId, String teacherName, String teacherAddress, List<TicketDTO> ticketList) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherAddress = teacherAddress;
		this.ticketList = ticketList;
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

	public List<TicketDTO> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<TicketDTO> ticketList) {
		this.ticketList = ticketList;
	}

	@Override
	public String toString() {
		return "ApparatusDTO [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAddress="
				+ teacherAddress + ", ticketList=" + ticketList + "]";
	}

}
