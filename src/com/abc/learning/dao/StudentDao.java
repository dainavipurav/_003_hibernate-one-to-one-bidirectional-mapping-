package com.abc.learning.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.learning.entity.Student;
import com.abc.learning.entity.StudentDetails;

public class StudentDao {
	public static String insertStudent(SessionFactory factory, Student student) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.persist(student);
			session.getTransaction().commit();
			return "Student inserted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Cannot insert student";
		} finally {
			session.close();
		}
	}

	public static String insertStudentDetails(SessionFactory factory, StudentDetails studentDetails) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.persist(studentDetails);
			session.getTransaction().commit();
			return "Student details inserted successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Cannot insert student details";
		} finally {
			session.close();
		}
	}

	public static String updateStudentDetailsById(SessionFactory factory, StudentDetails studentDetails, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			StudentDetails details = session.get(StudentDetails.class, id);
			details.setCollegeName(studentDetails.getCollegeName());
			details.setStream(studentDetails.getStream());

			Student student = details.getStudent();
			student.setAge(studentDetails.getStudent().getAge());
			student.setEmail(studentDetails.getStudent().getEmail());
			student.setName(studentDetails.getStudent().getName());

			session.update(details);

			session.getTransaction().commit();
			return "Student details updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Cannot update student details";
		} finally {
			session.close();
		}
	}

	public static String deleteStudentDetailsById(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			StudentDetails studentDetails = session.get(StudentDetails.class, id);

			session.delete(studentDetails);

			session.getTransaction().commit();

			return "Student details updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Cannot delete student details";
		} finally {
			session.close();
		}
	}

	public static StudentDetails getStudentDetailsById(SessionFactory factory, int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			 
            StudentDetails studentDetails = session.get(
                StudentDetails.class, id);
 
            studentDetails.setStudent(studentDetails.getStudent());
 
            session.getTransaction().commit();
 
            return studentDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public static List<StudentDetails> getStudentDetailsListByQuery(SessionFactory factory, String query){
		Session session = factory.getCurrentSession();
		List<StudentDetails> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list=session.createQuery(query,StudentDetails.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			session.close();
		}
	}
}
