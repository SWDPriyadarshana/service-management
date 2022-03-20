package com.home.serviceManagement.backend.service;

import java.util.List;

import com.home.serviceManagement.backend.dto.ApparatusDTO;

public interface ApparatusService {
	
	List<ApparatusDTO> findAllApparatus();
	
	ApparatusDTO findApparatus(String apparatusId);
	
	void save(String apparatusId,ApparatusDTO apparatusDTO);
	
	boolean update(String apparatusId,ApparatusDTO apparatusDTO);
	
	boolean delete(String apparatusId);
	
	

}
