package com.bilgeadam;

import java.time.LocalDate;
import java.time.Month;

import com.bilgeadam.dao.StudentDao;
import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.Gender;
import com.bilgeadam.entity.Student;
import com.bilgeadam.util.HibernateSession;

public class App {

	public static void main(String[] args) {
		StudentDao sDao = new StudentDao();
		Student melihDumanli = new Student();
		melihDumanli.setFirstName("Melih");
		melihDumanli.setLastName("Dumanlı");
		melihDumanli.setBirthDate(LocalDate.of(1985, Month.AUGUST, 20));
		melihDumanli.setGender(Gender.MALE);
		melihDumanli.setAddress(new Address("Atasehir","14/B","Istanbul"));
		
		sDao.delete(52);
	
	}

}
