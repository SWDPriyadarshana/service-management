package com.home.serviceManagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.serviceManagement.backend.entity.Ticket_Apparatus_PK;
import com.home.serviceManagement.backend.entity.Ticket_Appratus;

public interface Ticket_AppatusRepository extends JpaRepository<Ticket_Appratus,Ticket_Apparatus_PK> {

}
