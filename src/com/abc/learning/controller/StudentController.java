package com.abc.learning.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abc.learning.dao.StudentDao;
import com.abc.learning.entity.Student;
import com.abc.learning.entity.StudentDetails;

public class StudentController {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()//
				.configure("hibernate.cfg.xml")//
				.addAnnotatedClass(Student.class)//
				.addAnnotatedClass(StudentDetails.class)//
				.buildSessionFactory();
		
//		Insert Student by studentDetails
//		Student student = new Student("dP",27,"dp@gmail.com");
//		StudentDetails studentDetails = new StudentDetails("Gokhale");
//		student.setStudentDetails(studentDetails);
//		studentDetails.setStudent(student);
//		StudentDao.insertStudentDetails(factory, studentDetails);
//		Insert Student by studentDetails
		
//		Update student by student details by id
//		int id = 7;
//		Student student = new Student("YK",13,"yk@gmail.com");
//		StudentDetails studentDetails = new StudentDetails("Angels","Science");
//		studentDetails.setStudent(student);
//		System.out.println(StudentDao.updateStudentDetailsById(factory, studentDetails, id));
//		Update student by student details by id
		
//		Delete student details by id
//		int id = 9;
//		System.out.println(StudentDao.deleteStudentDetailsById(factory, id));
//		Delete student details by id
		
//		Read student details by id
//		int id = 4;
//		StudentDetails details = StudentDao.getStudentDetailsById(factory, id);
//		if(details!= null) {
//			System.out.println(details.toString());
//			System.out.println(details.getStudent().toString());
//		}else {
//			System.out.println("Record not found");
//		}
//		Read student details by id
		
//		Read List of student details by id
		String query = "FROM StudentDetails";
		List<StudentDetails> list = StudentDao.getStudentDetailsListByQuery(factory, query);
		if(list.isEmpty()) {
			System.out.println("No Records found");
		}else {
			for(StudentDetails details : list) {
				System.out.println(details.getStudent().toString());
			}
		}
//		Read List of student details by id
		
		factory.close();
	}
}
