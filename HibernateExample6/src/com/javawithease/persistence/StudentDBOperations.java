package com.javawithease.persistence;

import com.javawithease.business.Student;
import com.javawithease.business.Subject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;


public class StudentDBOperations {

    public Integer addStudent(Student student) {
        Transaction tx = null;
        Integer studentId = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            studentId = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentId;
    }


    public void showAllStudentDetails() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student").list();
            for (Student student : students) {
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("Last Name: " + student.getLastName());
                System.out.println("Class: " + student.getClassName());
                System.out.println("RollNo: " + student.getRollNo());
                System.out.println("Age: " + student.getAge());
                Collection<Subject> subjects = student.getSubjects();
                for (Subject subject : subjects) {
                    System.out.println("Subject Name:" + subject.getSubjectName());
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
