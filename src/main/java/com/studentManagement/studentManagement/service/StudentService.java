package com.studentManagement.studentManagement.service;

import com.studentManagement.studentManagement.entity.Student;
import com.studentManagement.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public void delStudent(int id){
        studentRepository.deleteById(id);
    }

    public Student getStudent(int id){
       return  studentRepository.findById(id);
    }

    /*
    public void updateInfoStudent(Student student){
       //setleme işlemi yap
    }*/

    public Student getStudentByName(String name){
     return  studentRepository.findStudentByName(name);
    }
}
