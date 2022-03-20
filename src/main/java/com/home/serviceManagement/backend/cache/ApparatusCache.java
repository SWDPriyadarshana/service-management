package com.home.serviceManagement.backend.cache;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.home.serviceManagement.backend.BackendApplication;
import com.home.serviceManagement.backend.dto.ApparatusDTO;
import com.home.serviceManagement.backend.entity.Apparatus;
import com.home.serviceManagement.backend.repository.ApparatusRepository;

@Component
public class ApparatusCache {

	@Autowired
	private ApparatusRepository apparatusRepository;

	private static final Logger logger = LoggerFactory.getLogger(ApparatusCache.class);

	@Cacheable(value = "apparatusCache")
	public List<String> getApparatusName() {
		logger.info("retrieve aparatus from db");
		List<String> apparatusNamelist = new ArrayList<String>();

		List<Apparatus> findAll = apparatusRepository.findAll();
		for (Apparatus apparatus : findAll) {
			String apparatusName = apparatus.getApparatusName();
			apparatusNamelist.add(apparatusName);
		}
		return apparatusNamelist;
	}

	@Cacheable(value = "apparatusListCache", key = "#apparatusName")
	public ApparatusDTO getApparatusDetail(String apparatusName) {
		logger.info("retrieve apparatusList from db");
		List<Apparatus> findAll = apparatusRepository.findAll();
		ApparatusDTO apparatusDTO = new ApparatusDTO();

		findAll.forEach(appratus -> {

			if (appratus.getApparatusName().equals("laptop")) {

				BeanUtils.copyProperties(appratus, apparatusDTO);

			}

		});
		return apparatusDTO;
	}

}
