package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentHashMap = new HashMap<>();

    HashMap<String,Teacher> teacherHashMap = new HashMap<>();

    HashMap<String,String> studentTeacherMap = new HashMap<>();

    HashMap<String,List<String>> teacherStudentMap = new HashMap<>();
    public void addStudent(Student student) {
        studentHashMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherHashMap.put(teacher.getName(), teacher);
        List<String> s = new ArrayList<>();
        teacherStudentMap.put(teacher.getName(), s);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher))
        {
            studentTeacherMap.put(student,teacher);
            List<String> s = new ArrayList<>();
            s = teacherStudentMap.get(teacher);

            if(!s.contains(student)) s.add(student);
            teacherStudentMap.put(teacher,s);
        }
    }

    public Student getStudentByName(String name) {

        return studentHashMap.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teacherHashMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        List<String> ans = new ArrayList<>();
        ans = teacherStudentMap.get(teacher);
        return ans;
    }

    public List<String> getAllStudents() {
        List<String> ans = new ArrayList<>();
        for(String s : studentHashMap.keySet())
        {
            ans.add(s);
        }
        return ans;
    }

    public void deleteTeacherByName(String teacher) {

        List<String> s= new ArrayList<>();
        s = teacherStudentMap.get(s);

        teacherStudentMap.remove(teacher);
        for(String c : s)
        {
            studentTeacherMap.remove(s);
            studentHashMap.remove(s);
        }

        teacherHashMap.remove(teacher);

    }

    public void deleteAllTeachers() {



        for(String s : studentTeacherMap.keySet())
        {
            studentHashMap.remove(s);
        }
        teacherHashMap.clear();
        teacherStudentMap.clear();
        studentTeacherMap.clear();
    }
}

