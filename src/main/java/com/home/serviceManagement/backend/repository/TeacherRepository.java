package com.home.serviceManagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.serviceManagement.backend.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String>{

}
