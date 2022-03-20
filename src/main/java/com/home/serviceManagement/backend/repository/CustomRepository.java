package com.home.serviceManagement.backend.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class CustomRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.home.serviceManagement.backend");
	EntityManager em = emf.createEntityManager();
	JPAQueryFactory queryFactory = new JPAQueryFactory(em);
	
	
	

}
