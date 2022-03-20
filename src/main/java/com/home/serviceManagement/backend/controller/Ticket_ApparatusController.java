package com.home.serviceManagement.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.serviceManagement.backend.dto.Ticket_ApparatusDTO;
import com.home.serviceManagement.backend.service.Ticket_ApparatusService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ticket-details")
public class Ticket_ApparatusController {
	@Autowired
	private Ticket_ApparatusService ticket_ApparatusService;
	
	@PutMapping("/{ticketId}/{apparatusId}")
	public void saveAppratusDetail(@PathVariable("ticketId") String ticketId,@PathVariable("apparatusId") String apparatusId,@RequestBody Ticket_ApparatusDTO ticket_ApparatusDTO) {
		ticket_ApparatusService.saveTicket_Apparatus(ticketId, apparatusId, ticket_ApparatusDTO);
	}

}
