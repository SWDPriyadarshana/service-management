package com.home.serviceManagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.serviceManagement.backend.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,String>{

}
