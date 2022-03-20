package com.home.serviceManagement.backend.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.serviceManagement.backend.dto.Ticket_ApparatusDTO;
import com.home.serviceManagement.backend.entity.Apparatus;
import com.home.serviceManagement.backend.entity.Ticket_Apparatus_PK;
import com.home.serviceManagement.backend.entity.Ticket_Appratus;
import com.home.serviceManagement.backend.repository.ApparatusRepository;
import com.home.serviceManagement.backend.repository.Ticket_AppatusRepository;
import com.home.serviceManagement.backend.service.Ticket_ApparatusService;

@Service
@Transactional
public class Ticket_ApparatusServiceImpl implements Ticket_ApparatusService {

	@Autowired
	private Ticket_AppatusRepository ticket_apparatusRepository;

	@Autowired
	private ApparatusRepository apparatusRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Ticket_ApparatusDTO> findAllTicket_Apparatus() {
	//List<Ticket_Appratus> findAll = ticket_apparatusRepository.findAll();
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Ticket_ApparatusDTO findTicket_Apparatus(String ticketId, String apparatusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTicket_Apparatus(String ticketId, String apparatusId, Ticket_ApparatusDTO ticket_ApparatusDTO) {
		if ((!ticketId.equals(ticket_ApparatusDTO.getTicketId()))
				|| (!apparatusId.equals(ticket_ApparatusDTO.getApparatusId()))) {
			throw new RuntimeException("ids are mismatch");
		}

	
		Ticket_Appratus ticket_Appratus2 = ticket_apparatusRepository.findById(new Ticket_Apparatus_PK(ticketId,apparatusId)).get();
		ticket_Appratus2.setStatus(ticket_ApparatusDTO.getStatus());
		ticket_Appratus2.setFine(ticket_ApparatusDTO.getFine());
		ticket_Appratus2.setIssduingdate(ticket_ApparatusDTO.getIssduingdate());
		ticket_Appratus2.setReturningDate(ticket_ApparatusDTO.getReturningDate());
		Apparatus apparatus = apparatusRepository.findById(apparatusId).get();
		if(apparatus.getApparatusCount()<ticket_Appratus2.getQty()) {
			throw new RuntimeException("storage low,can't resolve request.");
		}
		
		if (ticket_ApparatusDTO.getStatus().equals("approve")) {
			int apparatusNewQty = apparatus.getApparatusCount() - ticket_Appratus2.getQty();
			apparatus.setApparatusCount(apparatusNewQty);
		}else if (ticket_ApparatusDTO.getStatus().equals("close")) {
			int apparatusNewCloseQty = apparatus.getApparatusCount() + ticket_Appratus2.getQty();
			apparatus.setApparatusCount(apparatusNewCloseQty);
		}
		
		ticket_Appratus2.setApparatus(apparatus);
		
		ticket_apparatusRepository.save(ticket_Appratus2);
	}

	@Override
	public boolean updateTicket_Apparatus(String ticketId, String apparatusId,
			Ticket_ApparatusDTO ticket_ApparatusDTO) {

		if ((!ticketId.equals(ticket_ApparatusDTO.getTicketId()))
				|| (!apparatusId.equals(ticket_ApparatusDTO.getApparatusId()))) {
			throw new RuntimeException("ids are mismatch");
		}

		if (ticket_apparatusRepository.existsById(new Ticket_Apparatus_PK(ticketId, apparatusId))) {
			saveTicket_Apparatus(ticketId, apparatusId, ticket_ApparatusDTO);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteTicket_Apparatus(String ticketId, String apparatusId) {
		// TODO Auto-generated method stub
		return false;
	}

}
