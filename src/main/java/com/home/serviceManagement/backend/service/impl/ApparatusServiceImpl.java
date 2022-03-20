package com.home.serviceManagement.backend.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.serviceManagement.backend.dto.ApparatusDTO;
import com.home.serviceManagement.backend.entity.Apparatus;
import com.home.serviceManagement.backend.entity.Electrical_Apparatus;
import com.home.serviceManagement.backend.repository.ApparatusChildRepository;
import com.home.serviceManagement.backend.repository.ApparatusRepository;
import com.home.serviceManagement.backend.service.ApparatusService;

@Service
@Transactional
public class ApparatusServiceImpl implements ApparatusService {

	@Autowired
	private ApparatusRepository apparatusRepository;

	@Autowired
	private ApparatusChildRepository<Electrical_Apparatus> electrical_ApparatusRepository;

	@Transactional(readOnly = true)
	@Override
	public List<ApparatusDTO> findAllApparatus() {

		List<Apparatus> findAll = apparatusRepository.findAll();
		List<ApparatusDTO> apparatusDTOs = new ArrayList<ApparatusDTO>();
		findAll.forEach(apparatus -> {
			ApparatusDTO apparatusDTO = new ApparatusDTO();

			BeanUtils.copyProperties(apparatus, apparatusDTO);

			apparatusDTOs.add(apparatusDTO);
		});

		return apparatusDTOs;
	}

	@Transactional(readOnly = true)
	@Override
	public ApparatusDTO findApparatus(String apparatusId) {
		Apparatus apparatus = apparatusRepository.findById(apparatusId).get();

		ApparatusDTO apparatusDTO = new ApparatusDTO();
		BeanUtils.copyProperties(apparatus, apparatusDTO);

		return apparatusDTO;
	}

	@Override
	public void save(String apparatusId, ApparatusDTO apparatusDTO) {

		if (!apparatusId.equals(apparatusDTO.getApparatusId())) {
			throw new RuntimeException("Apparatus ids are mismatch");
		}

		Apparatus apparatus = new Apparatus();
		Electrical_Apparatus electrical_Apparatus = new Electrical_Apparatus();

		BeanUtils.copyProperties(apparatusDTO, electrical_Apparatus);

		electrical_ApparatusRepository.save(electrical_Apparatus);

	}

	@Override
	public boolean update(String apparatusId, ApparatusDTO apparatusDTO) {
		if (!apparatusId.equals(apparatusDTO.getApparatusId())) {
			throw new RuntimeException("Apparatus ids are mismatch");
		}
		if (apparatusRepository.existsById(apparatusId)) {
			save(apparatusId, apparatusDTO);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(String apparatusId) {
		apparatusRepository.deleteById(apparatusId);
		return true;
	}

}
