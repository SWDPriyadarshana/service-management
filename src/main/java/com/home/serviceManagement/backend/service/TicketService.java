package com.home.serviceManagement.backend.service;

import java.util.List;

import com.home.serviceManagement.backend.dto.TicketDTO;

public interface TicketService {
	
	List<TicketDTO> findAllTicket();
	
	TicketDTO findTicket(String ticketId);
	
	void save(TicketDTO ticketDTO);
	
	boolean update(TicketDTO ticketDTO);
	
	boolean delete(String ticketId);
	
	

}
