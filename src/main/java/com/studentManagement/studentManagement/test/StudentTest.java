package com.studentManagement.studentManagement.test;

import com.studentManagement.studentManagement.entity.Student;
import com.studentManagement.studentManagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest
public class StudentTest {

    @Autowired
    StudentService studentService;

    @Test
    public void addStudentTest(){
        Student student = new Student(1,"mehmet","koyuncu","5422416675","Ankara","Ankara-Gölbaşı","Hello PrimeFaces. This is my first example");
        this.studentService.addStudent(student);
        Student foundStudent= studentService.getStudentByName(student.getName());

        assertEquals(student,foundStudent);
        System.out.println(student.equals(foundStudent));
    }

    @Test
    public void updateStudentTest(){
        Student student = new Student(1,"mehmet","koyuncu","5422416675","Ankara","Ankara-Gölbaşı","Hello PrimeFaces. This is my first example");
        studentService.addStudent(student);
        student.setName("ahmet");
        studentService.addStudent(student);
        int id=student.getId();
        Student foundStudent=studentService.getStudent(id);
        assertEquals(student,foundStudent);
    }

    @Test
    public void deleteStudentTest(){
        Student student = new Student(1,"mehmet","koyuncu","5422416675","Ankara","Ankara-Gölbaşı","Hello PrimeFaces. This is my first example");
        studentService.addStudent(student);
        Student student2 = new Student(2,"ahmet","koyuncu","5422416675","Ankara","Ankara-Gölbaşı","Hello PrimeFaces. This is my first example");
        studentService.addStudent(student2);
        int id=student.getId();
        studentService.delStudent(id);
        assertTrue(studentService.getAllStudents().size()<2);
    }
}
