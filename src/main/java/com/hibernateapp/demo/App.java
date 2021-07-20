package com.hibernateapp.demo;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernateapp.dto.CollegeDTO;
import com.hibernateapp.dto.StudentDTO;

import vo.AddressVO;
import vo.SkillsVO;


public class App 
{
	private Session session;
	
	public void createSession() {
		if(this.session == null) {
			Configuration config = new Configuration().configure();
	        SessionFactory sessionFactory = config.buildSessionFactory();
	        this.session = sessionFactory.openSession();
		}  else {
			System.out.println("Something is null");
		}
	}
	
	
	@SuppressWarnings("restriction")
	public void performTransaction(Session session, StudentDTO student) {
		
		if(session != null && student != null) {
			Transaction tx = session.beginTransaction();
			 student.setStudentName("Alex");
	         student.setDob(new Date());
	         student.setEmail("Alex.mercer@gmail.com");
	         student.setGender("M");
	        
	         /*------Adress-VO---------*/ 
	         student.setAddress(new AddressVO("Pune","Maharastra","411014", "Vitthal Nagar"));
	         
	         /*------Skills-VO---------*/       
	         SkillsVO s1 = new SkillsVO();
	         s1.setSkillName("Java");
	         s1.setProficiency("AVERAGE");
	         
	         SkillsVO s2 = new SkillsVO();
	         s2.setSkillName("JavaScript");
	         s2.setProficiency("GOOD");
	        
	         
	         student.setSkills(Arrays.asList(s1,s2)); 
	         CollegeDTO c = new CollegeDTO();
	         c.setCollegeName("Gandhi Institute");
	         c.setCourses(Arrays.asList("CSE","CHEMICAL","ELECTRICAL"));
	         c.setStudents(Arrays.asList(student));
			 
	         session.persist(c);
	         tx.commit(); 
		} else {
			System.out.println("Session is null");
		}
		 
	}
	
	public void performQuery(Session session) {
		if(session.isOpen()) {
			Transaction tx = session.beginTransaction();

			//basic-fetch
			StudentDTO student = (StudentDTO)session.get(StudentDTO.class, 2);
			System.out.println("Fetched student: "+student);
			
			//-deprecated-retrieve-student details-//
			Query query = session.createNamedQuery("student.byId");
			query.setString("studentId", "2");
			List<StudentDTO> list = (List<StudentDTO>)query.list();
			System.out.println(list);
			
			
			/**
			 * to delete : session.delete(recordRef)
			 * to update : session.update(recordRef)
			 */ 
			
			
			//-Aggregate functions-
			
			
			tx.commit();
		}  else {
			System.out.println("Session is not open");
		}
	}
	
	
	@SuppressWarnings("restriction")
	public static void main( String[] args )
    {
		App app = new App();
		app.createSession();
        app.performTransaction(app.session, new StudentDTO());  
        
        //Querying
        app.createSession();
        app.performQuery(app.session);
    }
}
