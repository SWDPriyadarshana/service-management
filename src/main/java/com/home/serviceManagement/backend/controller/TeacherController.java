package com.home.serviceManagement.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.serviceManagement.backend.dto.TeacherDTO;
import com.home.serviceManagement.backend.dto.joinDto.TeacherTicketDTO;
import com.home.serviceManagement.backend.service.TeacherService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping(value="/{pageNumber}/{pageElement}/{sortType}")
	public List<TeacherDTO> findAll(@PathVariable("pageNumber") int pageNumber,@PathVariable("pageElement") int pageElement,@PathVariable("sortType") String sortType) {

		return teacherService.findAllTeacher(pageNumber,pageElement,sortType);

	}
	
	@GetMapping(value="/{teacherId}")
	public TeacherDTO findTeacher(@PathVariable("teacherId") String teacherId) {

		return teacherService.findTeacher(teacherId);

	}
	
	@PutMapping(value="/{teacherId}")
	public void saveTeacher(@PathVariable("teacherId") String teacherId,@RequestBody TeacherDTO teacherDTO) {
		teacherService.saveTeacher(teacherId, teacherDTO);
	}

	
	@PostMapping(value="/{teacherId}")
	public boolean updateTeacher(@PathVariable("teacherId") String teacherId,@RequestBody TeacherDTO teacherDTO) {
		return teacherService.updateTeacher(teacherId, teacherDTO);
	}
	
	
	@DeleteMapping(value="/{teacherId}")
	public boolean deleteTeacher(@PathVariable("teacherId") String teacherId) {
		return teacherService.deleteTeacher(teacherId);
	}

	@GetMapping(value="/dsl")
	public List<TeacherDTO> findTeacherDsl() {

		return teacherService.executeQuery();

	}

	@GetMapping(value="/dsljoin")
	public List<TeacherTicketDTO> findTeacherDslJoin() {

		return teacherService.executeQueryJoin();

	}



}
