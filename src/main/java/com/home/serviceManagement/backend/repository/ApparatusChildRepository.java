package com.home.serviceManagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.serviceManagement.backend.entity.Apparatus;
import com.home.serviceManagement.backend.entity.Electrical_Apparatus;

public interface ApparatusChildRepository<T extends Apparatus>  extends JpaRepository<T, String> {

}
