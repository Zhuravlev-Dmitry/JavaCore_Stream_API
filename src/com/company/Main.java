package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();

        Course course1 = new Course("Введение в тестирование");
        Course course2 = new Course("Java Core для тестировщиков");
        Course course3 = new Course("Тестирование веб-приложений");
        Course course4 = new Course("Компьютерные сети");
        Course course5 = new Course("Linux. Рабочая станция");
        Course course6 = new Course("Основы баз данных");
        Course course7 = new Course("Java. Уровень 1");
        Course course8 = new Course("Автоматизация тестирования Web UI на Java");
        Course course9 = new Course("Тестирование backend на Java");
        Course course10 = new Course("HTML/CSS для тестировщиков");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);
        courses.add(course8);
        courses.add(course9);
        courses.add(course10);

        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Vasily", Arrays.asList(course1,course3,course7));
        Student student2 = new Student("Dmitry", Arrays.asList(course1,course2,course3,course4,course7,course10));
        Student student3 = new Student("Tatiana", Arrays.asList(course3,course2,course6,course9,course10));
        Student student4 = new Student("Fedor", Arrays.asList(course4,course2,course10,course8));
        Student student5 = new Student("Anna", Arrays.asList(course1,course2,course4,course5));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println("Список уникальных курсов : ");
        System.out.println(getDistCourses(students));
        System.out.println("Список любознательных студентов : ");
        System.out.println(getTreeStudents(students));
        System.out.println("Список студентов, посещающих курс : ");
        System.out.println(getStudentsCourse(students,course1));
    }

    //Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
    // на которые подписаны студенты.

    public static List<String> getDistCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .map((course) -> course .getName())
                .collect(Collectors.toList());
    }

    //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
    // (любознательность определяется количеством курсов).

    public static List<String> getTreeStudents(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> (s2.getAllCourses().size()) - (s1.getAllCourses().size()))
                .limit(3)
                .map((student) -> student.getName())
                .collect(Collectors.toList());
    }

    //Написать функцию, принимающую на вход список Student и экземпляр Course,
    // возвращающую список студентов, которые посещают этот курс.

    public static List<String> getStudentsCourse(List<Student> students, Course course) {
        System.out.println(course.getName());
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .map((student) -> student.getName())
                .collect(Collectors.toList());
    }


}
