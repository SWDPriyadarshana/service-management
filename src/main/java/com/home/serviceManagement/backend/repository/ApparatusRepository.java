package com.home.serviceManagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.serviceManagement.backend.entity.Apparatus;

public interface ApparatusRepository extends JpaRepository<Apparatus, String> {

}
