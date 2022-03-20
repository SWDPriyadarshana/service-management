package com.home.serviceManagement.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.home.serviceManagement.backend.entity.Teacher;

public class TicketDTO implements Serializable{

	private String ticketId;
	private Date date;
	private TeacherDTO teacherDTO;
	private List<Ticket_ApparatusDTO> ticket_ApparatusDTOs;

	public TicketDTO() {
		super();
	}

	public TicketDTO(String ticketId, Date date, TeacherDTO teacherDTO,
			List<Ticket_ApparatusDTO> ticket_ApparatusDTOs) {
		super();
		this.ticketId = ticketId;
		this.date = date;
		this.teacherDTO = teacherDTO;
		this.ticket_ApparatusDTOs = ticket_ApparatusDTOs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Ticket_ApparatusDTO> getTicket_ApparatusDTOs() {
		return ticket_ApparatusDTOs;
	}

	public void setTicket_ApparatusDTOs(List<Ticket_ApparatusDTO> ticket_ApparatusDTOs) {
		this.ticket_ApparatusDTOs = ticket_ApparatusDTOs;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public TeacherDTO getTeacherDTO() {
		return teacherDTO;
	}

	public void setTeacherDTO(TeacherDTO teacherDTO) {
		this.teacherDTO = teacherDTO;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", date=" + date + ", teacherDTO=" + teacherDTO
				+ ", ticket_ApparatusDTOs=" + ticket_ApparatusDTOs + "]";
	}

}
