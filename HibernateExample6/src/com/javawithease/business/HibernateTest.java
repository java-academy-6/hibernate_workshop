package com.javawithease.business;

import com.javawithease.persistence.StudentDBOperations;

import java.util.ArrayList;


public class HibernateTest {
    public static void main(String args[]) {
        ArrayList subjectList1 = new ArrayList();
        subjectList1.add(new Subject("Data Structure"));
        subjectList1.add(new Subject("Operting System"));

        ArrayList subjectList2 = new ArrayList();
        subjectList2.add(new Subject("Compier"));
        subjectList2.add(new Subject("Networking"));
        subjectList2.add(new Subject("DBMS"));

        Student student1 = new Student("Bharat", "Jaiswal",
                "MCA final", "MCA/07/72", 27);
        Student student2 = new Student("Sahdev", "Gorila",
                "MCA final", "MCA/07/73", 32);

        student1.setSubjects(subjectList1);
        student2.setSubjects(subjectList2);

        StudentDBOperations obj = new StudentDBOperations();
        obj.addStudent(student1);
        obj.addStudent(student2);

        System.out.println("------------------------------------------\n\n\n");
        System.out.println(student1.getSubjects().getClass());

        System.out.println("Zadanie!");
        System.out.println("Spróbuj przerobić program, tak aby uzyskać inny typ Kolekcji, np PersistentIdentifierBag");
        System.out.println("\n\n\n------------------------------------------");


        obj.showAllStudentDetails();

    }
}
