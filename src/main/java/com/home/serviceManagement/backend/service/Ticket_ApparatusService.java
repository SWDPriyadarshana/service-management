package com.home.serviceManagement.backend.service;

import java.util.List;

import com.home.serviceManagement.backend.dto.Ticket_ApparatusDTO;

public interface Ticket_ApparatusService {
	List<Ticket_ApparatusDTO> findAllTicket_Apparatus();
	
	Ticket_ApparatusDTO findTicket_Apparatus(String ticketId,String apparatusId);
	
	void saveTicket_Apparatus(String ticketId,String apparatusId,Ticket_ApparatusDTO ticket_ApparatusDTO);
	
	boolean updateTicket_Apparatus(String ticketId,String apparatusId,Ticket_ApparatusDTO ticket_ApparatusDTO);
	
	boolean deleteTicket_Apparatus(String ticketId,String apparatusId);
	

}
