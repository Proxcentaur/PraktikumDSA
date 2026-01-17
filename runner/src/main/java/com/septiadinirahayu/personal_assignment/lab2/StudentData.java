package com.septiadinirahayu.personal_assignment.lab2;

public class StudentData {
    String name;
    String studentId;
    String major;

    public StudentData(String name, String studentId, String major) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }
}
