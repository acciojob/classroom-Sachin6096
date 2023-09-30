package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;
    public void addStudent(Student student) {

        studentRepo.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepo.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepo.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepo.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepo.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepo.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepo.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepo.deleteAllTeachers();
    }
}
