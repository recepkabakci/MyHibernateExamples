package com.bilgeadam.dao;

import org.hibernate.Session;

import com.bilgeadam.entity.Student;

public class StudentDao implements IRepository<Student>{

	@Override
	public void create(Student entity) {
		
		try(Session session = databaseConnection()){
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Student data is added to DB");
		}catch(Exception e){
			System.out.println("Problem on adding Student");
		}
		
	}

	@Override
	public void update(long id, Student entity) {
		
		try (Session session = databaseConnection()){
			
			Student updateStudent = find(id);
			if(updateStudent!= null) {
				updateStudent.setFirstName(entity.getFirstName());
				updateStudent.setLastName(entity.getLastName());
				updateStudent.setBirthDate(entity.getBirthDate());
				updateStudent.setGender(entity.getGender());
				updateStudent.setAddress(entity.getAddress());
				updateStudent.setCourses(entity.getCourses());
				
				
				session.getTransaction().begin();
				session.merge(updateStudent);
				session.getTransaction().commit();
				System.out.println("Succsca updated");
			}
			
			
		} catch (Exception e) {
		System.out.println("Some problem occured while UPDATE operation");
		e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		
		try (Session session = databaseConnection()){
			Student deleteStudent = find(id);
			if(deleteStudent != null){
				session.beginTransaction();
				session.remove(deleteStudent);
				session.getTransaction().commit();
			}	
			} catch (Exception e) {
			System.out.println("Some problem occured while DELETE operation");
			e.getMessage();
			}
		
	}

	@Override
	public Student find(long id) {
		
		try (Session session = databaseConnection()){
			
		Student student = session.find(Student.class,id);
			
			if(student != null) {
				System.out.println("Student found: " + student);
				return student;
			}else {
				System.out.println("Student not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND(student) operation");
		}
		
		return null;
	}

}
