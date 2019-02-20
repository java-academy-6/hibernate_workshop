package com.javawithease.business;


public class Subject {
    //data members
    private int subjectId;
    private String subjectName;

    //no argument constructor
    public Subject() {

    }

    //argument constructor
    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    //getter and setter methods
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
