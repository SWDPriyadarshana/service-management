package com.home.serviceManagement.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.serviceManagement.backend.dto.TeacherDTO;
import com.home.serviceManagement.backend.dto.TicketDTO;
import com.home.serviceManagement.backend.dto.Ticket_ApparatusDTO;
import com.home.serviceManagement.backend.entity.Teacher;
import com.home.serviceManagement.backend.entity.Ticket;
import com.home.serviceManagement.backend.entity.Ticket_Apparatus_PK;
import com.home.serviceManagement.backend.entity.Ticket_Appratus;
import com.home.serviceManagement.backend.repository.TicketRepository;
import com.home.serviceManagement.backend.service.TicketService;
import com.home.serviceManagement.backend.util.TicketId;

@Service
@Transactional
public class TicketServieImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Transactional(readOnly = true)

	@Override
	public List<TicketDTO> findAllTicket() {
		List<Ticket> findAll = ticketRepository.findAll();
		List<TicketDTO> findTicketDTOs = new ArrayList<TicketDTO>();
		findAll.forEach(ticket -> {
			TicketDTO ticketDTO = new TicketDTO();
			BeanUtils.copyProperties(ticket, ticketDTO);

			Teacher teacher = ticket.getTeacher();
			TeacherDTO teacherDTO = new TeacherDTO();
			BeanUtils.copyProperties(teacher, teacherDTO);

			List<Ticket_Appratus> ticket_Appratus = ticket.getTicket_Appratus();
			List<Ticket_ApparatusDTO> ticket_ApparatusDTOs = new ArrayList<>();
			ticket_Appratus.forEach(ticket_apparatus -> {
				Ticket_ApparatusDTO ticket_ApparatusDTO = new Ticket_ApparatusDTO();
				BeanUtils.copyProperties(ticket_Appratus, ticket_ApparatusDTO);
				ticket_ApparatusDTOs.add(ticket_ApparatusDTO);
			});
			ticketDTO.setTicket_ApparatusDTOs(ticket_ApparatusDTOs);
			ticketDTO.setTeacherDTO(teacherDTO);
			findTicketDTOs.add(ticketDTO);
		});
		return findTicketDTOs;
	}

	@Transactional(readOnly = true)

	@Override
	public TicketDTO findTicket(String ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId).get();

		TicketDTO ticketDTO = new TicketDTO();

		BeanUtils.copyProperties(ticket, ticketDTO);

		Teacher teacher = ticket.getTeacher();
		TeacherDTO teacherDTO = new TeacherDTO();
		BeanUtils.copyProperties(teacher, teacherDTO);

		List<Ticket_Appratus> ticket_AppratusList = ticket.getTicket_Appratus();
		List<Ticket_ApparatusDTO> ticket_ApparatusDTOs = new ArrayList<Ticket_ApparatusDTO>();

		ticket_AppratusList.forEach(ticket_Appratus -> {
			Ticket_ApparatusDTO ticket_ApparatusDTO = new Ticket_ApparatusDTO();
			BeanUtils.copyProperties(ticket_Appratus, ticket_ApparatusDTO);
			ticket_ApparatusDTOs.add(ticket_ApparatusDTO);
		});
		ticketDTO.setTicket_ApparatusDTOs(ticket_ApparatusDTOs);
		ticketDTO.setTeacherDTO(teacherDTO);
		return ticketDTO;
	}

	@Override
	public void save(TicketDTO ticketDTO) {
		System.out.println(ticketDTO);

		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(ticketDTO, ticket);

		// int[] ticketNumber = new int[]{1};
		TicketId ticketId = new TicketId();
		String timeStamp = ticketId.timeStamp();
		ticket.setTicketId("TRN" + timeStamp);

		List<Ticket_ApparatusDTO> ticket_ApparatusDTOsList = ticketDTO.getTicket_ApparatusDTOs();
		List<Ticket_Appratus> ticket_AppratusList = new ArrayList<>();

		TeacherDTO teacherDTO = ticketDTO.getTeacherDTO();
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacherDTO, teacher);

		ticket_ApparatusDTOsList.forEach(ticket_AppratusDTO -> {
			Ticket_Appratus ticket_Appratus = new Ticket_Appratus();
			BeanUtils.copyProperties(ticket_AppratusDTO, ticket_Appratus);
			ticket_Appratus.setTicket_Apparatus_PK(
					new Ticket_Apparatus_PK(("TRN" + timeStamp), ticket_AppratusDTO.getApparatusId()));

			ticket_AppratusList.add(ticket_Appratus);
		});
		ticket.setTicket_Appratus(ticket_AppratusList);
		ticket.setTeacher(teacher);
		ticketRepository.save(ticket);

	}

	@Override
	public boolean update(TicketDTO ticketDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ticketId) {
		ticketRepository.deleteById(ticketId);
		return true;
	}

}
