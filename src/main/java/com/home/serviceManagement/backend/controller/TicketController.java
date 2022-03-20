package com.home.serviceManagement.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.serviceManagement.backend.dto.TicketDTO;
import com.home.serviceManagement.backend.service.TicketService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public List<TicketDTO> findAll(){
		return ticketService.findAllTicket();
	}
	@GetMapping(value="/{ticketId}")
	public TicketDTO findTicket(@PathVariable("ticketId") String ticketId){
		return ticketService.findTicket(ticketId);
	}
	
	@PutMapping
	public void save(@RequestBody TicketDTO ticketDTO){
		ticketService.save(ticketDTO);;
	}
	
	@DeleteMapping(value="/{ticketId}")
	public boolean deleteTicket(@PathVariable("ticketId") String ticketId){
		return ticketService.delete(ticketId);
	}

}
