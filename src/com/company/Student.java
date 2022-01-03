package com.company;

import java.util.List;


public class Student {
    private String name;
    private List<Course> courses;;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getAllCourses() {
        return this.courses;
    }


    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
