package com.home.serviceManagement.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.home.serviceManagement.backend.dto.joinDto.TeacherTicketDTO;
import com.home.serviceManagement.backend.entity.*;
import com.querydsl.core.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.serviceManagement.backend.dto.TeacherDTO;
import com.home.serviceManagement.backend.dto.TicketDTO;
import com.home.serviceManagement.backend.dto.Ticket_ApparatusDTO;
import com.home.serviceManagement.backend.repository.TeacherRepository;
import com.home.serviceManagement.backend.service.TeacherService;
import com.home.serviceManagement.backend.util.TicketId;
import com.querydsl.jpa.impl.JPAQueryFactory;



@Service
@Transactional
//@CacheConfig(cacheNames = {"teacherCache","oneteacherCache"})
@CacheConfig(cacheNames = {"teacherCache"})
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private Provider<EntityManager> entityManager;

	
	private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);



//	@Override
//	public void executeQuery() {
//
//		JPAQueryFactory query = new JPAQueryFactory(entityManager);
//		QTeacher teacher = QTeacher.teacher;
//		Teacher c = queryFactory.selectFrom(teacher)
//				.where(user.login.eq("David"))
//				.fetchOne();
//	}
//
	
	
	
	
	@Transactional(readOnly=true)
	@Cacheable
	@Override
	public List<TeacherDTO> findAllTeacher(int pageNumber,int pageElemenr,String sortType) {
		
		logger.info("Calling Repository method to retrieve event");
		String sortby=null;
		if(sortType.equals("id")) {
			sortby="teacherId";
		}else if(sortType.equals("name")) {
			sortby="teacherName";
		}
		Pageable sortedByPriceDesc = PageRequest.of(pageNumber, pageElemenr, Sort.by(""+sortby+"").descending());//begin from 0
		                                                                                           //  PageRequest.of(0, 10) this returns 1st page 10 element,2nd page only has 3 element
		                                                                                        // (1,3)- fist of all, all elements devide by 3 and sparate pageing accordingly,2nd page with 3 element
		
		//List<Teacher> findAll = teacherRepository.findAll(sortedByPriceDesc);
		Page<Teacher> findAll = teacherRepository.findAll(sortedByPriceDesc);
		List<TeacherDTO> teList=new ArrayList<TeacherDTO>();
	
		
		findAll.forEach(teacher->{
			List<TicketDTO> ticketDTOs=new ArrayList<TicketDTO>();
			TeacherDTO teacherDTO=new TeacherDTO();
			BeanUtils.copyProperties(teacher, teacherDTO);
			
//			retreieve ticket
			List<Ticket> ticketsList = teacher.getTicketsList();
			ticketsList.forEach(ticket->{
				TicketDTO ticketDTO=new TicketDTO();
				BeanUtils.copyProperties(ticket, ticketDTO);
				ticketDTOs.add(ticketDTO);
			});
			teacherDTO.setTicketList(ticketDTOs);
			teList.add(teacherDTO);
		});
		
		return teList;
	}

	@Transactional(readOnly=true)
	
	@Cacheable
	@Override
	public TeacherDTO findTeacher(String teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).get();
		TeacherDTO teacherDTO=new TeacherDTO();
		BeanUtils.copyProperties(teacher, teacherDTO);
		
		List<Ticket> ticketsList = teacher.getTicketsList();
		List<TicketDTO> ticketDTOs=new ArrayList<>();
		ticketsList.forEach(ticket->{
			
			
		TicketDTO ticketDTO=new TicketDTO();
			BeanUtils.copyProperties(ticket, ticketDTO);
			ticketDTOs.add(ticketDTO);
		});
		teacherDTO.setTicketList(ticketDTOs);
		return teacherDTO;
	}

	@Cacheable
	@CacheEvict(allEntries = true)
	@Override
	public void saveTeacher(String teacherId, TeacherDTO teacherDTO) {
		System.out.println(teacherDTO);
		
		 if (!teacherId.equals(teacherDTO.getTeacherId())){
	            throw new RuntimeException("Teacher IDs are mismatched");
	        }
		Teacher teacher=new Teacher();
		BeanUtils.copyProperties(teacherDTO, teacher);
		
		//ticket save
		List<TicketDTO> ticketList = teacherDTO.getTicketList();
		List<Ticket> tickets=new ArrayList<Ticket>();
		int[] ticketNumber = new int[]{1};
		
		
		 
		ticketList.forEach(ticketDTO->{
			
			//ticket
			Ticket ticket=new Ticket();
			
			BeanUtils.copyProperties(ticketDTO, ticket);
		
		
			ticket.setTeacher(teacher);
			
			TicketId ticketId=new TicketId();
			String timeStamp = ticketId.timeStamp();
			ticket.setTicketId("TRN"+timeStamp+ticketNumber[0]++);
			
			//ticket_apparatus
			List<Ticket_ApparatusDTO> ticket_ApparatusDTOs = ticketDTO.getTicket_ApparatusDTOs();
			
			List<Ticket_Appratus> ticket_AppratusList=new ArrayList<>();
			
			if(ticket_ApparatusDTOs!=null) {
				ticket_ApparatusDTOs.forEach(ticket_appratusDTO->{
					Ticket_Appratus ticket_Appratus=new Ticket_Appratus();
					BeanUtils.copyProperties(ticket_appratusDTO, ticket_Appratus);
					
					ticket_Appratus.setTicket_Apparatus_PK(new Ticket_Apparatus_PK("TRN"+timeStamp+ticketNumber[0]++,ticket_appratusDTO.getApparatusId()));
					
					
					ticket_AppratusList.add(ticket_Appratus);
					
				});
				ticket.setTicket_Appratus(ticket_AppratusList);
			}
			
			tickets.add(ticket);
		});
		
		teacher.setTicketsList(tickets);
		System.out.println(teacher);
		teacherRepository.save(teacher);
		
		
	}
	@Cacheable
	@CacheEvict(allEntries = true)
	@Override
	public boolean updateTeacher(String teacherId, TeacherDTO teacherDTO) {

		 if (!teacherId.equals(teacherDTO.getTeacherId())){
	            throw new RuntimeException("Teacher IDs are mismatched");
	        }
		if( teacherRepository.existsById(teacherId)) {
			saveTeacher(teacherId, teacherDTO);
			return true;
		}
		else {
			return false;
		}
		 
		
	}

	@Cacheable
	@CacheEvict(allEntries = true)
	@Override
	public boolean deleteTeacher(String teacherId) {
		teacherRepository.deleteById(teacherId);
		return true;
	}


	@Cacheable
	@Override
	public List<TeacherDTO> executeQuery() {
		JPAQueryFactory query = new JPAQueryFactory(entityManager);
		QTeacher teacher = QTeacher.teacher;

		/**
		 * comma represent 'and' operation
		 * Basic query
		 *

		 */
	/*	List<Teacher> teacherList = query.selectFrom(teacher)
				.where(
						teacher.teacherName.eq("nuwan"),
						teacher.teacherAddress.eq("horana"))
				.fetch();*/



		/**
		 * select teacherName from teacher where teacherAddress="Horana";
		 * Basic query
		 */
	/*	List<String> teacherNameList = query.selectFrom(teacher)
				.where(teacher.teacherAddress.eq("horana"))
				.select(teacher.teacherName)
				.fetch();*/








		/**
		 * Order
		 * filter
		 */

		/*List<Teacher> teacherList = query.selectFrom(teacher)
				.where(
						teacher.teacherName.eq("nuwan"),
						teacher.teacherAddress.eq("horana")).orderBy(teacher.teacherId.asc())
				.fetch();
*/
		/**
		 * Order with out where clause
		 */


		List<Teacher> teacherList = query.selectFrom(teacher)
				.orderBy(teacher.teacherName.asc(),teacher.teacherId.desc())
				.fetch();


		List<TeacherDTO> teacherDtoList=new ArrayList<>();
		teacherList.forEach(teacherEntity->{
			TeacherDTO teacherDTO=new TeacherDTO();
			BeanUtils.copyProperties(teacherEntity,teacherDTO);
			teacherDtoList.add(teacherDTO);
		});
		return teacherDtoList;
	}


	/**
	 * Three tables are joined and return List<Object>
	 * @return
	 */

	@Override
	public List<TeacherTicketDTO> executeQueryJoin() {
		JPAQueryFactory query = new JPAQueryFactory(entityManager);
		QTeacher teacher = QTeacher.teacher;
		QTicket ticket=QTicket.ticket;
		QTicket_Appratus ticket_appratus=QTicket_Appratus.ticket_Appratus;

		List<Tuple> teacherTicketTuple = query.from(teacher)
				.innerJoin(ticket)
				.on(teacher.teacherId.eq(ticket.teacher.teacherId))
				.innerJoin(ticket_appratus)
				.on(ticket.ticketId.eq(ticket_appratus.ticket_Apparatus_PK.ticketId))
				.where(teacher.teacherName.eq("Sanka"))
				.select(teacher, ticket,ticket_appratus)
				.fetch();

		List<TeacherTicketDTO> teacherTicketDTOList=new ArrayList<>();

		teacherTicketTuple.forEach(teacherTicket->{
			TeacherTicketDTO teacherTicketDTO=new TeacherTicketDTO();
			BeanUtils.copyProperties(teacherTicket.get(teacher),teacherTicketDTO);
			BeanUtils.copyProperties(teacherTicket.get(ticket),teacherTicketDTO);
			BeanUtils.copyProperties(teacherTicket.get(ticket_appratus),teacherTicketDTO);

			teacherTicketDTO.setApparatusId(teacherTicket.get(ticket_appratus).getApparatus().getApparatusId());

			teacherTicketDTOList.add(teacherTicketDTO);
		});

		return teacherTicketDTOList;


	}

/**
 * *>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * 		 * Note different between QueryDSL 4.0.2+ vs old
 * 		 * |||||||||||
 * 		 * QCard qCard = QCard.card;
 * 		 * List<Card> cards = getQuery().from(qCard)
 * 		 *     .innerJoin(qCard.person).fetch()
 * 		 *     .list(qCard);
 * 		 *
 * 		 *For QueryDSL 4.0.2+
 * 		 *
 * 		 *QCard qCard = QCard.card;
 * 		 * List<Card> cards = getQuery().from(qCard)
 * 		 *     .innerJoin(qCard.person).fetchJoin()
 * 		 *     .select(qCard).fetch();
 * 		 *
 * 		 *>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 */

}
